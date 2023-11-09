//package com.finzly.demo.service;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//import com.finzly.demo.component.JwtUtil;
//import com.finzly.demo.entity.AuthenticationToken;
//
//@Service
//public class AuthenticationService {
//
//    private final AuthenticationManager authenticationManager;
//    private final UserDetailsService userDetailsService;
//    private final JwtUtil jwtUtil;
//
//    public AuthenticationService(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtUtil jwtUtil) {
//        this.authenticationManager = authenticationManager;
//        this.userDetailsService = userDetailsService;
//        this.jwtUtil = jwtUtil;
//    }
//
//    public String authenticate(String username, String password) {
//        // Perform authentication (you may need to customize this based on your application)
//        Authentication authentication = authenticationManager.authenticate(new AuthenticationToken(username, password));
//
//        // Generate JWT token upon successful authentication
//        String token = jwtUtil.generateToken(authentication.getName());
//
//        return token;
//    }
//}