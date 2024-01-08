package com.davacom.checkOutPayment.configurations.security;

import com.davacom.checkOutPayment.entities.UserOfApp;
import com.davacom.checkOutPayment.repositories.UserOfAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.stream.Collectors;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
        private final JwtAuthFilter jwtAuthFilter;
        private final UserOfAppRepository userOfAppRepository;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/**/auth/**/", "/**/register","/**/app-users").permitAll()
                .anyRequest()
                .authenticated()
                 .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                 .addFilterBefore( jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
        }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
     }

     @Bean
     public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
     }
    @Bean
    public UserDetailsService userDetailsService () {
    return email -> {
        UserOfApp user = userOfAppRepository.findByEmail(email);
            if(user != null){
            return new User(user.getEmail()
                    , user.getPassword(),
                    user.getRoles().stream()
                            .map((role) -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList()));
            }else {
                 throw new UsernameNotFoundException("Invalid email or password");
            }
        };
    }


//
//    @Bean
//    public UserDetailsService userDetailsService () {
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//                UserOfApp user = userOfAppRepository.findByEmail(email);
//                if(user != null){
//                    return new User(user.getEmail()
//                            , user.getPassword(),
//                            user.getRoles().stream()
//                                    .map((role) -> new SimpleGrantedAuthority(role.getName()))
//                                    .collect(Collectors.toList()));
//                }else {
//                    throw new UsernameNotFoundException("Invalid email or password");
//                }
//            }
//        };
//    }

}
