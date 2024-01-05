package com.saurabh.sp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;

import com.saurabh.sp.model.*;
import com.saurabh.sp.repo.UserRepository;
import com.saurabh.sp.service.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {
      
	  @Autowired
	  private UserRepository userRepository;
	  
	    @Autowired
	    private PasswordEncoder passwordEncoder;
	   
	    private final AuthService authService;

	    @Autowired
	    public UserController(AuthService authService) {
	        this.authService = authService;
	    }
	 
	  /* ================== TO CREATE A NEW USER ACCOUNT ===================== */
	 @PostMapping("/signup")
	 private ResponseEntity<String> createUser(@RequestBody UserDtls userDtls) {
		   
		 if(userDtls.getEmailId() == null || userDtls.getPassword() == null) {
			 return ResponseEntity.badRequest().body("EmailId and Password are required.");
		 }
		 
		  boolean f = userRepository.existsByEmailId(userDtls.getEmailId());
		  
		  if(f) {
			  return ResponseEntity.badRequest().body("EmailId is already taken.");
		  }
		 
		  UserDtls newUser = new UserDtls();
		  newUser.setEmailId(userDtls.getEmailId());
		  newUser.setPassword(passwordEncoder.encode(userDtls.getPassword()));
		  
		  userRepository.save(newUser);

	      return ResponseEntity.ok("User registered successfully.");
	 }
	 
	 /* ============== LOGIN INTO EXISTING TOKEN AND RECEIVING A TOKEN ================== */
	@PostMapping("/login")
	private LoginResponse loginUser(@RequestBody @Validated LoginRequest request){
				
		return authService.attemptLogin(request.getEmail(), request.getPassword());
		
	}
	 
}
