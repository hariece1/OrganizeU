package com.EventM.OrganizeU.Emp.Websecurity;


import com.EventM.OrganizeU.Emp.Service.CustomUserDetailsService;
import com.EventM.OrganizeU.Emp.Service.LoginHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig {
    @Autowired
    LoginHandler loginHandler;

    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public  AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider  provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(c -> c.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/assets/**").permitAll()
                        .requestMatchers("/login")
                        .permitAll() // Allow public access to login page
                        .anyRequest().hasAuthority("user")
                        // Secure other pages
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

