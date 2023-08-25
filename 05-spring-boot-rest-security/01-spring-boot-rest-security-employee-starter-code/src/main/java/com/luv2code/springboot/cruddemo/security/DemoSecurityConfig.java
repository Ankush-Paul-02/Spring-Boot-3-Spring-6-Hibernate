package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    //! Add support for JDBC ... more hardcoded users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        //? Tells Spring security to use JDBC auth with our data source
        return new JdbcUserDetailsManager(dataSource);
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

    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails ankush = User.builder().username("ankush").password("{noop}232002")   //? noop = plain text
                .roles("EMPLOYEE").build();

        UserDetails sid = User.builder().username("sid").password("{noop}232002").roles("EMPLOYEE", "MANAGER").build();

        UserDetails deepon = User.builder().username("deepon").password("{noop}232002").roles("EMPLOYEE", "MANAGER", "ADMIN").build();
        return new InMemoryUserDetailsManager(ankush, sid, deepon);
    }*/
}
