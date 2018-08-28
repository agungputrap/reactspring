package com.agung.agungtesting.auth;

import com.agung.agungtesting.domain.Pengguna;
import com.agung.agungtesting.dto.auth.LoginRequest;
import com.agung.agungtesting.dto.pengguna.PenggunaCustom;
import com.agung.agungtesting.eventbus.publisher.AsyncEventPublisher;
import com.agung.agungtesting.exception.auth.TokenExpiredException;
import com.agung.agungtesting.service.PenggunaService;
import org.joda.time.DateTime;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.keys.HmacKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.time.ZoneOffset.UTC;

@Component
public class JwtService {

    private static final String ISSUER = "com.agung.agungtesting";
    public static final String USERNAME = "username";

    public static final String CLAIM_USER = "user";
    public static final String CLAIM_AUTH = "auth";
    public static final String CLAIM_LIST_MENU = "list_menu";

    @Autowired PenggunaService penggunaService;

    @Autowired AsyncEventPublisher asyncEventPublisher;

    @Autowired SecretKeyProvider secretKeyProvider;

    @Autowired LastActivitySession lastActivitySession;

    Logger log = LoggerFactory.getLogger(this.getClass());

    public String tokenFor(LoginRequest loginRequest) throws Exception {
        byte[] secretKey = secretKeyProvider.getKey();
        Date expiration = Date.from(LocalDateTime.now(UTC).plusHours(2).toInstant(UTC));

        JwtClaims claims = new JwtClaims();
        claims.setExpirationTimeMinutesInTheFuture(5);
        claims.setSubject("DEMO");
        claims.setIssuer("com.agung.agungtesting");
        claims.setAudience("com.agung.agungtesting");
        claims.setExpirationTimeMinutesInTheFuture(120); // time when the token will expire (10 minutes from now)
        claims.setGeneratedJwtId(); // a unique identifier for the token
        claims.setIssuedAtToNow();  // when the token was issued/created (now)
        claims.setClaim("email","mail@example.com"); // additional claims/attributes about the subject can be added
        claims.setClaim("auth", true);

        List<String> roles = Arrays.asList("R_USER", "R_ADD_USER", "R_EDIT_USER");
        claims.setStringListClaim("roles", roles); // multi-valued claims work too and will end up as a JSON array

        Key key = new HmacKey(secretKey);

        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(claims.toJson());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.HMAC_SHA256);
        jws.setKey(key);
        jws.setDoKeyValidation(false); // relaxes the key length requirement

        String innerJwt = jws.getCompactSerialization();
        return innerJwt;
    }


    public PenggunaCustom verify(String token) throws Exception {

        byte[] secretKey = secretKeyProvider.getKey();
        Key key = new HmacKey(secretKey);

        JsonWebSignature jws = new JsonWebSignature();
        jws.setKey(key);
        jws.setCompactSerialization(token);

        if(!jws.verifySignature()) return null;

        String payload = jws.getPayload();
        JwtClaims jwtClaims = JwtClaims.parse(payload);

        String username = jwtClaims.getClaimValue(CLAIM_USER, String.class);

        if (!lastActivitySession.hasSession(username)) {
            lastActivitySession.put(username, new Date());
        } else {
            Date lastActivityDate = lastActivitySession.getLastActivity(username);

            DateTime lastActivityTime = new DateTime(lastActivityDate);
            DateTime currentTime = new DateTime();

            if (currentTime.isBefore(lastActivityTime.plusMinutes(30))) {
                lastActivitySession.put(username, new Date());
            } else {
                lastActivitySession.remove(username);
                throw new TokenExpiredException();
            }
        }

        return penggunaService.getPenggunaCustomByUsernameOrEmail(username);
    }

    public String generateToken(LoginRequest loginRequest) throws Exception {
        Pengguna user = penggunaService.getPenggunaByUsernameOrEmail(loginRequest.getUsername());

        JwtClaims claims = new JwtClaims();
        claims.setExpirationTimeMinutesInTheFuture(30);
        claims.setSubject("APP");
        claims.setIssuer("com.app");
        claims.setAudience("com.app");
        claims.setGeneratedJwtId(); // a unique identifier for the token
        claims.setIssuedAtToNow();  // when the token was issued/created (now)
        claims.setClaim(CLAIM_USER, user.getUsername()); // additional claims/attributes about the subject can be added
        claims.setClaim(CLAIM_AUTH, true);

        byte[] secretKey = secretKeyProvider.getKey();
        Key key = new HmacKey(secretKey);

        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(claims.toJson());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.HMAC_SHA256);
        jws.setKey(key);
        jws.setDoKeyValidation(false); // relaxes the key length requirement

        String innerJwt = jws.getCompactSerialization();
        return innerJwt;
    }
}
