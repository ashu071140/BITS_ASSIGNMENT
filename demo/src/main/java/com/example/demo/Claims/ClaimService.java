package com.example.demo.Claims;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Enumeration;
import java.util.Optional;

@Service
public class ClaimService {
    @Autowired
    private ClaimRepository claimRepository;

    public ResponseEntity<?> findByVin(ClaimRequest claimRequest) {
        Optional<Claim> claim = claimRepository
                .findByVINAndInsuranceNo(claimRequest.getVin(), claimRequest.getInsuranceNo());

        if (claim.isPresent()) return ResponseEntity.ok(claim.get());

        if (claim.isEmpty()) return ResponseEntity.ok(new Claim());

        return ResponseEntity.ok("Unknown Error");
    }

    public void generateClaims() {

        Claim claim = new Claim(
                12345L,
                54321L,
                "John",
                "Doe",
                23990
        );
        claimRepository.save(claim);

        Claim claim2 = new Claim(
                00000L,
                99999L,
                "Farooq",
                "Al-Saadi",
                10500.34
        );

        claimRepository.save(claim2);

    }
}
