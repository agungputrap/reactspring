package com.agung.agungtesting.config;

import com.agung.agungtesting.auth.CustomAccessDeniedHandler;
import com.agung.agungtesting.auth.CustomAuthFilter;
import com.agung.agungtesting.auth.CustomAuthenticationEntryPoint;
import com.agung.agungtesting.auth.CustomAuthenticationProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity(debug = false)
@EnableGlobalMethodSecurity(prePostEnabled = true) //TODO: jika semua udah ok, jadikan true
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CustomAuthFilter customAuthFilter;
    @Autowired
    CustomAuthenticationProvider customAuthenticationProvider;
    @Autowired
    CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    @Autowired
    CustomAccessDeniedHandler customAccessDeniedHandler;

    @Override
    public void configure(AuthenticationManagerBuilder auth)  throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.csrf().ignoringAntMatchers("/api/auth/login");
        http.csrf().disable();

        String[] whitelistPath = new String[]{
                "/api/auth/login",
                "/api/auth/register",
                "/api/password/reset-request",
                "/api/password/reset",
                "/api/download/**/*",
                "/static/**/*",
                "/index.html",
                "/service-worker.js"
        };

        http.authorizeRequests()
                .antMatchers(whitelistPath).permitAll()
                .antMatchers("/api/**/*").authenticated()
                .and()
                .addFilterBefore(customAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(customAuthenticationEntryPoint)
                .accessDeniedHandler(customAccessDeniedHandler);

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
