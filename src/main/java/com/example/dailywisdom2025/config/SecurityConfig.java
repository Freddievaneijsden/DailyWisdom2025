package com.example.dailywisdom2025.config;
//
//import com.example.dailywisdom2025.filters.ApiKeyAuthenticationFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.logout.LogoutFilter;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableMethodSecurity
public class SecurityConfig {

//    @Bean
////    @Order(1) Multiply SecurityFilter
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .addFilterAfter(new ApiKeyAuthenticationFilter(), LogoutFilter.class)
////                .formLogin(Customizer.withDefaults()) //Authentication method, redirect to root /
//                .authorizeHttpRequests((authorizationManagerRequestMatcherRegistry) ->
//                        authorizationManagerRequestMatcherRegistry
//                                .requestMatchers("/login").permitAll()
//                                .requestMatchers("/upload").hasRole("ADMIN")
//                                .requestMatchers("/**").authenticated()
//                                .requestMatchers("/api/index").hasRole("USER")
//                                .anyRequest().denyAll() //Everything not listed above is denied
//                        );
//        return http.build();
//    }

//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//    //Never use this implementation
//    @Bean
//    UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder() //acceptable for demos but not production
//                .username("freddie")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}
