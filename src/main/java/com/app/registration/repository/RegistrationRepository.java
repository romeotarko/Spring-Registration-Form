package com.app.registration.repository;

import com.app.registration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User,Integer> {

   public User findByEmail(String email);

   public User findByEmailAndPassword(String email,String password);

}
