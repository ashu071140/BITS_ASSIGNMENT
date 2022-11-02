package com.example.demo.Accounts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public ResponseEntity<?> registerAccount(RegistrationRequest request) {

        if (accountRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("email already exists");

        }

//        if (!request.getPassword().equals(request.getRetypePassword()) || request.getPassword().length() < 8) {
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("passwords do not match, try again");
//        } else {
//
//        }

        User user = new User(
                request.getEmail(),
                request.getPassword()
        );
        accountRepository.save(user);

        return ResponseEntity.status(HttpStatus.OK).body("Your account has been created");

    }


    public ResponseEntity<?> login(LoginRequest request) {

        Optional<User> user = accountRepository.findByEmail(request.getEmail());

        if (user.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");

        if (!user.get().getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("incorrect-password");
        }

        return ResponseEntity.status(HttpStatus.OK).body("accepted");


    }
}
