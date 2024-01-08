package com.davacom.checkOutPayment.controllers;


import com.davacom.checkOutPayment.configurations.security.JwtUtil;
import com.davacom.checkOutPayment.dtos.AuthenticateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController("/auth")
@RequiredArgsConstructor
public class AuthenticationControl {

    AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;


    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticateRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        if(userDetails != null) {
             return ResponseEntity.ok().body(jwtUtil.generateToken(userDetails));
        }
        return ResponseEntity.status(400).body("Your credentials are invalid");
    }
}
