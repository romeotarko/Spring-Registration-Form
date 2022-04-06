package com.app.registration.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, name = "ID")
    private UUID id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name="PHONE")
    private Integer phone;

    public User(UUID id, String email, String userName, String password, Integer phone) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.phone=phone;
    }

    public User() {
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
