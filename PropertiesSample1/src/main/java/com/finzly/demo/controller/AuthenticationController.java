//package com.finzly.demo.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.finzly.demo.entity.AuthenticationRequest;
//import com.finzly.demo.entity.AuthenticationResponse;
//import com.finzly.demo.service.AuthenticationService;
//
//@RestController
//public class AuthenticationController {
//	private final AuthenticationService authenticationService;
//	public AuthenticationController(AuthenticationService authenticationService) {
//		this.authenticationService = authenticationService;
//	}
//	
//	@PostMapping("/authenticate")
//	public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request){
//		String token = authenticationService.authenticate(request.getUsername(), request.getPassword());
//		return ResponseEntity.ok(new AuthenticationResponse(token));
//	}
//}
