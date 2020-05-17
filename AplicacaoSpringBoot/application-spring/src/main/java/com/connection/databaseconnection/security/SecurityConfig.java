//package com.connection.databaseconnection.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserBaseAcess userBaseAcess;
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.
//                userDetailsService(userBaseAcess)
//                .passwordEncoder(encoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/post/**").hasAnyRole("USER")
//                .antMatchers("/eventos/**").hasAnyRole("USER")
//                .antMatchers("/conhecimentos/**").hasAnyRole("USER")
//                .antMatchers("/user/login").permitAll()
//                .antMatchers("/user/cadastro").permitAll()
//                .antMatchers("/user/**").hasAnyRole("USER")
//        .and()
//                .httpBasic();
//    }
//}
