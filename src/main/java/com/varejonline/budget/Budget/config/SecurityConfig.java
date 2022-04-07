package com.varejonline.budget.Budget.config;

import com.varejonline.budget.Budget.repositories.UserRepository;
import com.varejonline.budget.Budget.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception{
        return new UserService(userRepository);
    }

    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET).permitAll()
                .antMatchers(HttpMethod.POST).permitAll()
                .antMatchers("/login", "/h2/**").permitAll()
                .antMatchers("/admin").access("hasAuthority('ADMIN')")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").permitAll()
                .and()
                .httpBasic();

        http.csrf().disable();
        http.headers().frameOptions().disable();

    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsServiceBean())
                .passwordEncoder(passwordEncoder());

        /*auth.inMemoryAuthentication()
                .withUser("manager").password(passwordEncoder().encode("manager"))
                .authorities("ADMIN")
                .and()
                .withUser("user")
                .password(passwordEncoder().encode("password"))
                .authorities("USER");*/

    }
}

