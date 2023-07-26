package ism.Gestionappro.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    UserDetailsService service;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=
                new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(service);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin();
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests()
                .requestMatchers("/webjars/**").permitAll()
                .requestMatchers("/accueil").permitAll()
                .requestMatchers("/api/**").permitAll()
                .requestMatchers("/rp/**").hasAuthority("RP")
                .requestMatchers("/ac/**").hasAuthority("AC")
                .requestMatchers("/professeur/**").hasAuthority("Professeur")
                .requestMatchers("/etudiant/**").hasAuthority("Etudiant")
                .anyRequest()
                .authenticated();
        http.exceptionHandling().accessDeniedPage("/403");
        return http.build();
    }

}
