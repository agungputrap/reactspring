package com.agung.agungtesting.auth;

import com.agung.agungtesting.domain.Pengguna;
import com.agung.agungtesting.dto.auth.LoginRequest;
import com.agung.agungtesting.dto.pengguna.PenggunaCustom;
import com.agung.agungtesting.service.PenggunaService;
import com.agung.agungtesting.service.RoleService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthService {

    @Autowired
    JwtService jwtService;

    @Autowired
    PenggunaService penggunaService;
    @Autowired
    RoleService roleService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    public PenggunaCustom getCurrentUserweb() {
        UserAuthentication userAuthentication = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication();

        try {
            return jwtService.verify((String) userAuthentication.getCredentials());
        } catch (Exception e) {
            log.error("getCurrentUserweb : ", e);
            return null;
        }
    }

    public UserAuthentication authenticate(UserAuthentication userAuthentication) throws Exception {

        String jwtToken = (String) userAuthentication.getCredentials();
        PenggunaCustom user = jwtService.verify(jwtToken);
        if (user == null) {
            throw new TokenNotValidException();
        }

        userAuthentication.setAuthenticated(true);
        userAuthentication.setPrincipal(user);

        List<Long> listIdRole = roleService.getListIdRoleByIdUser(user.getId().longValue());
        List<SimpleGrantedAuthority> listAuthority = this.getListSimpleGrantedAuthorityByPeran(roleService.getListPeranByIdPengguna(user.getId().longValue()));

        userAuthentication.setAuthorities(listAuthority);

        return userAuthentication;
    }

    /*public AppAuthentication authenticate(AppAuthentication appAuthentication) {
        AppCredentials appCredentials = (AppCredentials) appAuthentication.getCredentials();

        App app = appService.getAppByKode(appCredentials.getKode());
        if (app == null) {
            throw new AppNotFoundException();
        }

        if (app.getApiKey().equals(appCredentials.getApiKey())) {
            appAuthentication.setAuthenticated(true);
            appAuthentication.setPrincipal(app);

            List<Long> listIdRole = roleService.getListIdRoleByIdApp(app.getId());
            appAuthentication.setAuthorities(this.getListSimpleGrantedAuthorityByListIdRole(listIdRole));
        }

        return appAuthentication;
    }*/

    /*public List<SimpleGrantedAuthority> getListSimpleGrantedAuthorityByListIdRole(List<Long> listIdRole){
        List<SimpleGrantedAuthority> listAuthority = Lists.newArrayList();

        for (String kodePermission : permissionService.getSetKodePermissionByListIdRole(listIdRole)) {
            listAuthority.add(new SimpleGrantedAuthority(kodePermission));
        }

        return listAuthority;
    }*/

    public List<SimpleGrantedAuthority> getListSimpleGrantedAuthorityByPeran(List<String> listPeran){
        List<SimpleGrantedAuthority> listAuthority = Lists.newArrayList();

        for (String kodePermission : listPeran) {
            listAuthority.add(new SimpleGrantedAuthority(kodePermission));
        }

        return listAuthority;
    }

    public void checkLogin(LoginRequest loginRequest) {
        Pengguna user = penggunaService.getPenggunaByUsernameOrEmail(loginRequest.getUsername());
        if (user == null) {
            throw new UserNotFoundException();
        }

        if (!BCrypt.checkpw(loginRequest.getPassword(), user.getPassword())) {
            throw new UserPassNotValidException();
        }
    }
}
