package com.app.registration.service;

import com.app.registration.dto.UserLogin;
import com.app.registration.model.User;
import com.app.registration.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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


    public UserLogin fetchUserByEmailAndPassword(UserLogin userLogin) throws Exception {
        String existingEmail = userLogin.getEmail();
        String existingPassword = userLogin.getPassword();
        UserLogin userObject = null;
        if (existingEmail != null && existingPassword != null) {
            userObject = registrationRepository.findByEmailAndPassword(existingEmail, existingPassword);
            if (userObject == null) {
                throw new Exception("Bad credentials , this user doesn't exists");
            }
        }
        return userObject;
    }
}
