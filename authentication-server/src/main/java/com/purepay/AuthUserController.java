package com.purepay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by AndreaValenziano on 30/05/18.
 */
@RestController
public class AuthUserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("/me")
    public Principal getCurrentLoggedInUser(Principal user) {
        return user;
    }

    @GetMapping("/")
    public String home(Principal user){
        return "Manager: "+authenticationManager;
    }





}
