package com.app.registration.controller;

import com.app.registration.dto.UserLogin;
import com.app.registration.model.User;
import com.app.registration.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return new ResponseEntity<>(registrationService.fetchUserByEmail(user), HttpStatus.CREATED);
    }

    @GetMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UserLogin> loginUser(@PathVariable UserLogin userLogin) throws Exception {
        return new ResponseEntity<> (registrationService.fetchUserByEmailAndPassword(userLogin), HttpStatus.OK);
    }

}
