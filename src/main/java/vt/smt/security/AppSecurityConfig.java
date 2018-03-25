package vt.smt.security;
//

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
// http://docs.spring.io/spring-boot/docs/current/reference/html/howto-security.html
// Switch off the Spring Boot security configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

//    private AccessDeniedHandler accessDeniedHandler;

    private UserDetailsService userDetailsService;

//    @Autowired
//    public void setAccessDeniedHandler(AccessDeniedHandler accessDeniedHandler) {
//        this.accessDeniedHandler = accessDeniedHandler;
//    }

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // roles admin allow to access /admin/**
    // roles user allow to access /**
    // custom 403 access denied handler
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/",
                        "/index.jsf",
                        "/registration.jsf",
                        "/javax.faces.resource/**"
                ).permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/main.jsf", "/theory.jsf", "/battle.jsf", "/adventure.jsf", "/login").hasAnyRole("USER")
                .anyRequest().authenticated();
        http
                .formLogin()
                .loginPage("/index.jsf")
                .failureUrl("/index.jsf?error=true");

        http.logout()
                .logoutSuccessUrl("/index.jsf")
                .permitAll()
                .and()
                .exceptionHandling();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**",
                        "/resources/css/**", "/resources/img/**","/javax.faces.resource/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider
                = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder(11);
//    }

}