package com.gin.job_tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());

        // this is list of URLs that require authentication to the website before user can view URL
        // all URLs are acceptable to everyone except for the one listed here.
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/jobs/**").authenticated()
                .requestMatchers("/people/**").authenticated()
                .requestMatchers("/todos/**").authenticated()
                .anyRequest().permitAll()
        );

        http.formLogin(formLogin -> formLogin
                // this is url for login page. this needs a controller method to listen and show the login page
                .loginPage("/login/login")
                // spring security has this controller method created for us already..
                // and we are just configuring URL where it submits to
                .loginProcessingUrl("/login/loginSubmit"));

        http.logout(formLogout -> formLogout
                .invalidateHttpSession(true)
                // this is URL implemented by Spring Security
                // we are just configuring the URL getmapping
                .logoutUrl("/login/logout")
                // where does it go when logged out
                .logoutSuccessUrl("/")
                .deleteCookies("username", "JSESSIONID"));

        http.exceptionHandling(exception -> exception.accessDeniedPage("/404"));
        return http.build();
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
