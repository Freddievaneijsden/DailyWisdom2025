package com.example.dailywisdom2025.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(Customizer.withDefaults()) //Authentication method
                .authorizeHttpRequests((authorizationManagerRequestMatcherRegistry) ->
                        authorizationManagerRequestMatcherRegistry
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/upload").hasRole("ADMIN")
                                .requestMatchers("/**").authenticated()
                                .anyRequest().denyAll() //everything not listed above is denied
                        );
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    //Never use this implementation
    @Bean
    UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder() //acceptable for demos but not production
                .username("freddie")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
