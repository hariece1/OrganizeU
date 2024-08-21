package com.EventM.OrganizeU.Emp.Websecurity;


import com.EventM.OrganizeU.Emp.Service.LoginHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

//@Configuration
//@EnableWebSecurity
//@Order(1)
public class SecurityConfig {
    @Autowired
    LoginHandler loginHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(c -> c.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/assets/**").permitAll()
                        .requestMatchers("/login")
                        .permitAll() // Allow public access to login page
                        .anyRequest().
                        authenticated() // Secure other pages
                )

                .formLogin(form -> form
                        .loginPage("/login") // Set the login page URL
                                .successHandler(loginHandler).permitAll()
//                        .permitAll() // Allow everyone to access the login page
                ).exceptionHandling(exception -> exception
                        .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")) // Redirect to login on authentication error
                )
                ;


        return http.build();
    }
}

