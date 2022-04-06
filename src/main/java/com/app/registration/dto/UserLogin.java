package com.app.registration.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {

    @NotBlank(message = "Email must not be empty")
    private String email;

    @NotBlank(message = "Username must not be empty")
    private String userName;

    @NotBlank(message = "Password must not be empty")
    private String password;

    @NotBlank(message = "Phone must not be empty")
    private Integer phone;


}
