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

        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/jobs/**").authenticated()
                .requestMatchers("/people/**").authenticated()
                .requestMatchers("/todos/**").authenticated()
                .anyRequest().permitAll()
        );

        http.formLogin(formLogin -> formLogin
                .loginPage("/login/login")
                .loginProcessingUrl("/login/loginSubmit"));

        http.logout(formLogout -> formLogout
                .invalidateHttpSession(true)
                .logoutUrl("/login/logout")
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
