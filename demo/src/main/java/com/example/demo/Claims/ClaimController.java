package com.example.demo.Claims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @PostMapping(value = "/make")
    public ResponseEntity<?> makeClaim(@RequestBody ClaimRequest request) {
        return claimService.findByVin(request);
    }

    @PostMapping(path = "/generate")
    public ResponseEntity<?> generateUsers() {
        claimService.generateClaims();
        return ResponseEntity.ok("Claims have been generated");

    }
}
