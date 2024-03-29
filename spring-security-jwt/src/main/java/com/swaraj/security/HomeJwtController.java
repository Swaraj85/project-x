package com.swaraj.security;

import com.swaraj.security.model.AuthenticationRequest;
import com.swaraj.security.model.AuthenticationResponse;
import com.swaraj.security.service.MyUserDetailsService;
import com.swaraj.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeJwtController {

    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private MyUserDetailsService myUserDetailsService;
    @Autowired private JwtUtil jwtUtil;

    @GetMapping("/hello")
    public String getHelloWorld() {
        return "hello world jwt!!";
    }


    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),
                        authenticationRequest.getPassword()));

        UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
        final String generatedJwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(generatedJwt));
    }
}
