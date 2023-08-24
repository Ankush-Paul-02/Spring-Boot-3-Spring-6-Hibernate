package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails ankush = User.builder().username("ankush").password("{noop}232002")   //? noop = plain text
                .roles("EMPLOYEE").build();

        UserDetails sid = User.builder().username("sid").password("{noop}232002").roles("EMPLOYEE", "MANAGER").build();

        UserDetails deepon = User.builder().username("deepon").password("{noop}232002").roles("EMPLOYEE", "MANAGER", "ADMIN").build();
        return new InMemoryUserDetailsManager(ankush, sid, deepon);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configure -> configure
                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );
        //! Use HTTP basic auth
        httpSecurity.httpBasic(Customizer.withDefaults());
        //! Disable Cross Site Request Forgery (CSRF)
        //! In general, not required for stateless REST APIs that use POST, PUT, DELETE and PATCH
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        return httpSecurity.build();
    }
}
