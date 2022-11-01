package com.example.demo.Accounts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public ResponseEntity<?> registerAccount(RegistrationRequest request) {

        if(accountRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("email already exists");

        }

        if(!request.getPassword().equals(request.getRetypePassword()) || request.getPassword().length() < 8) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("passwords do not match, try again");
        } else {

        }

        User user = new User(
                request.getEmail(),
                request.getFirstName(),
                request.getLastName(),
                request.getPassword()
        );
        accountRepository.save(user);

        return ResponseEntity.ok("Signup accepted");
    }
}
