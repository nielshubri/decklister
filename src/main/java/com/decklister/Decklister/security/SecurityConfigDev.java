package com.decklister.Decklister.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Profile("dev")
public class SecurityConfigDev extends WebSecurityConfigurerAdapter {

    @Autowired
    DecklisterUserDetailsService decklisterUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(decklisterUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/users").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/judge/**").hasRole("JUDGE")
                .antMatchers("/player/**").hasRole("PLAYER")

                .and()

                .httpBasic()

                .and()

                .headers().frameOptions().disable()

                .and()

                .csrf().disable();
    }
}
