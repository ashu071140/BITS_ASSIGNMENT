package com.example.demo.Accounts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String retypePassword;
}
