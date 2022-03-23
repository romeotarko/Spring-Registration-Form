package com.app.registration.controller;

import com.app.registration.model.User;
import com.app.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/user")
    public User registerUser(@RequestBody User user) throws Exception {
        String existingEmail= user.getEmailId();
        if(existingEmail != null && !existingEmail.isBlank()){
           User userObject = registrationService.fetchUserByEmailId(existingEmail);
            if(userObject != null){
               throw new Exception("User with "+existingEmail+" already exists");
            }
        }
        User userObject=null;
        userObject = registrationService.saveUser(user);
        return userObject;
    }
}
