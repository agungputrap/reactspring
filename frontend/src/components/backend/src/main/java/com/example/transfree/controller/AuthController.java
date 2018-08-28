package com.agung.agungtesting.controller;

import com.agung.agungtesting.auth.AuthService;
import com.agung.agungtesting.auth.JwtService;
import com.agung.agungtesting.auth.LastActivitySession;
import com.agung.agungtesting.domain.Pengguna;
import com.agung.agungtesting.dto.auth.LoginRequest;
import com.agung.agungtesting.dto.auth.LoginResponse;
import com.agung.agungtesting.dto.auth.LogoutRequest;
import com.agung.agungtesting.dto.auth.RegisterRequest;
import com.agung.agungtesting.dto.pengguna.PenggunaCustom;
import com.agung.agungtesting.dto.pengguna.PenggunaResponse;
import com.agung.agungtesting.service.PenggunaService;
import com.agung.agungtesting.service.RoleService;
import com.agung.agungtesting.util.DebugUtil;
import com.agung.agungtesting.util.RestValidatorUtil;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

//@CrossOrigin(origins = "http://localhost:4100")
@RestController
public class AuthController extends BaseRestController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    final static String ERROR_MSG = "Failed to authenticate";
    final static String ERROR_GET_MENU_MSG = "Failed to load menu";

    @Autowired JwtService jwtService;
    @Autowired AuthService authService;
    @Autowired PenggunaService penggunaService;
    @Autowired RoleService roleService;
    @Autowired LastActivitySession lastActivitySession;
    @Autowired RestValidatorUtil rv;
    @Autowired DebugUtil d;

    //WARN: This is PUBLIC API. Don't give @PreAuthorize
    @RequestMapping(value="/auth/login", method = RequestMethod.POST)
    public ResponseEntity postLogin(@RequestBody final LoginRequest loginRequest) throws Exception {
        String salt = BCrypt.gensalt();
        String hashpwd = BCrypt.hashpw(loginRequest.getPassword(), salt);

        ResponseEntity responseEntity = null;
        try {
            try {
                authService.checkLogin(loginRequest);
            } catch (Exception e) {
                log.error("AUTH LOGIN", e);
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(rv.buildError(e, ERROR_MSG));
            }

            String idToken = jwtService.generateToken(loginRequest);

            PenggunaCustom pc = penggunaService.getPenggunaCustomByUsernameOrEmail(loginRequest.getUsername());
            pc.setIdToken(idToken);

            // responseEntity =  ResponseEntity.ok(new LoginResponse(idToken, Lists.newArrayList(setKodeMenu), pengguna));
            responseEntity =  ResponseEntity.ok(new PenggunaResponse(idToken, pc, pc.getIdPeran().longValue()));
        } catch (Exception e) {
            log.error("AUTH LOGIN", e);
            responseEntity = ResponseEntity.badRequest().body(rv.buildError(e, ERROR_MSG));
        }

        return responseEntity;
    }

    @PostMapping(value = "/auth/logout")
    public ResponseEntity logout(@RequestBody LogoutRequest logoutRequest) {
        try {
            PenggunaCustom userweb = authService.getCurrentUserweb();
            lastActivitySession.remove(userweb.getUsername());
        } catch (Exception e) {
            log.error("LOGOUT", e);
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/auth/register")
    public ResponseEntity register(@RequestBody RegisterRequest user) {

        ResponseEntity responseEntity = null;
        try {
            log.info("user : {} ", user);
            System.out.println("USER : " + d.toString(user));
            Pengguna pengguna = penggunaService.addPenggunaByRequest(user);
            LoginRequest lr = new LoginRequest(user.getUsername(), user.getPassword());
            String idToken = jwtService.generateToken(lr);

            List<Long> listIdRole = roleService.getListIdRoleByIdUser(pengguna.getId());

            // responseEntity =  ResponseEntity.ok(new LoginResponse(idToken, Lists.newArrayList(setKodeMenu), pengguna));
            responseEntity =  ResponseEntity.ok(new LoginResponse(idToken, pengguna, listIdRole.get(0)));
        } catch (Exception e) {
            log.error("REGISTER", e);
            responseEntity = ResponseEntity.badRequest().body(rv.buildError(e, ERROR_MSG));
        }

        return responseEntity;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(value="/user", method = RequestMethod.GET)
    public ResponseEntity CurrentUser() throws Exception {
        ResponseEntity responseEntity = null;
        try {
            PenggunaCustom pengguna = authService.getCurrentUserweb();
            responseEntity =  ResponseEntity.ok(pengguna);
            log.debug("PENGGUNA : {}", pengguna);
        } catch (Exception e) {
            log.error("AUTH LOGIN", e);
            responseEntity = ResponseEntity.badRequest().body(rv.buildError(e, ERROR_MSG));
        }

        return responseEntity;
    }
}
