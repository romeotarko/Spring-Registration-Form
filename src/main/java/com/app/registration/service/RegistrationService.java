package com.app.registration.service;

import com.app.registration.dto.UserLogin;
import com.app.registration.model.User;
import com.app.registration.repository.RegistrationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public User saveUser(User user) {
        return registrationRepository.save(user);
    }

    public User fetchUserByEmail(User user) throws Exception {

        String existingEmail = user.getEmail();
        if (existingEmail != null && !existingEmail.isBlank()) {
            User userObject = registrationRepository.findByEmail(user.getEmail());
            if (userObject != null) {
                throw new Exception("User with " + existingEmail + " already exists");
            }
        }
        User userObject = null;
        userObject = saveUser(user);
        //TODO Send a message on Phone number to notify the user for the registration
        return userObject;
    }


    public User fetchUserByEmailAndPassword(UserLogin userLogin) throws Exception {
        User user = new User();
        user.setEmail(userLogin.getEmail());
        user.setPassword( userLogin.getPassword());
        UserLogin userObject = null;
        if (user.getEmail() != null && user.getPassword() != null) {
            userObject = registrationRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
            if (userObject == null) {
                throw new Exception("Bad credentials , this user doesn't exists");
            }
        }
        return user;
    }
}
