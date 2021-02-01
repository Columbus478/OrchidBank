/**
 * 
 */
package com.OrchidBank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.OrchidBank.Authentication.Token_generator;
import com.OrchidBank.Request.LoginRequest;
import com.OrchidBank.ResponseEntity.AuthResponse;
import com.OrchidBank.Service.UserService;

/**
 * @author Samuel Columbus Jan 30, 2021
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  private static final long serialVersionUID = 1L;

  private static final long TIME_TO_LIVE = 15 * 60000;
  private static final String ISSUER = "ORCHID_BANK";
  @Autowired
  AuthenticationManager authenticationManager;
  @Autowired
  Token_generator token_generator;
  @Autowired
  UserService userService;

  @PostMapping("/login")
  public ResponseEntity<AuthResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {

    Authentication authentication =
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            loginRequest.getAccountNumber(), loginRequest.getAccountPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = token_generator.createJWT(authentication, ISSUER, TIME_TO_LIVE);

    return ResponseEntity.ok(new AuthResponse(true, jwt));
  }
}
