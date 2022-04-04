package com.app.registration.controller;

import com.app.registration.model.User;
import com.app.registration.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Transactional
@RestController
@RequestMapping("/user")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;


    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<User> registerUser(@RequestBody User user) throws Exception {
        User registerUser = registrationService.fetchUserByEmail(user);
        return ResponseEntity.ok(registerUser);
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<User> loginUser(@RequestBody User user) throws Exception {
        User loginUser=registrationService.fetchUserByEmailAndPassword(user);
        return ResponseEntity.ok(loginUser);
    }

}
