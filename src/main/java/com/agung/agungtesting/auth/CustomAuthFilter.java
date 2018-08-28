package com.agung.agungtesting.auth;

import com.agung.agungtesting.util.DebugUtil;
import com.agung.agungtesting.util.RestValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthFilter implements Filter {

    Logger log = LoggerFactory.getLogger(this.getClass());

    private static final String BEARER = "Bearer";
    private static final String BASIC = "Basic";

    @Autowired
    RestValidatorUtil rv;
    @Autowired
    DebugUtil d;
    @Autowired
    HeaderHandler handler;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.info("doFilter");

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        handler.process(servletRequest, servletResponse);
        String authorization = servletRequest.getHeader("Authorization");
        if (authorization != null) {
//            log.info("authorization is not null : {}", authorization);
            log.info("authorization is not null");

            // 1) Request dari Web
            if (authorization.contains(BEARER)) {
                String token = authorization.replaceAll(BEARER + " ", "");
                if (!StringUtils.isEmpty(token) && token.split("\\.").length == 3) {
                    UserAuthentication userAuthentication = new UserAuthentication(token);

//                    log.info("token : {}", d.toString(token));
                    log.info("token");

                    SecurityContextHolder.getContext().setAuthentication(userAuthentication);
                }
            }
            /*else if (authorization.contains(BASIC)) {
                // 2) Request dari App
                String base64Decoded = authorization.replaceAll(BASIC + " ", "");
                if (!StringUtils.isEmpty(base64Decoded)) {
                    String[] kodeAndKey = new String(Base64Utils.decodeFromString(base64Decoded)).split(":");

                    String kode = kodeAndKey[0];
                    String apiKey = kodeAndKey[1];

                    AppCredentials appCredentials = new AppCredentials(kode, apiKey);
                    AppAuthentication appAuthentication = new AppAuthentication(appCredentials);

                    log.info("appCredentials : {}", d.toString(appCredentials));

                    SecurityContextHolder.getContext().setAuthentication(appAuthentication);
                }
            }*/


        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("destroy");
    }
}
