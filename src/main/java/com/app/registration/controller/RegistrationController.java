package com.app.registration.controller;

import com.app.registration.model.User;
import com.app.registration.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Transactional
@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/user")
    @CrossOrigin(origins = "http://localhost:4200")
    public User registerUser(@RequestBody User user) throws Exception {
        String existingEmail= user.getEmail();
        if(existingEmail != null && !existingEmail.isBlank()){
           User userObject = registrationService.fetchUserByEmail(existingEmail);
            if(userObject != null){
               throw new Exception("User with "+existingEmail+" already exists");
            }
        }
        User userObject=null;
        userObject = registrationService.saveUser(user);
        return userObject;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception {
        String existingEmail=user.getEmail();
        String existingPassword=user.getPassword();
        User userObject=null;
        if(existingEmail!=null && existingPassword!=null){
            userObject=registrationService.fetchUserByEmailAndPassword(existingEmail,existingPassword);
        }
        if(userObject == null){
            throw new Exception("Bad credentials , this user doesn't exists");
        }

       return userObject;
    }
}
