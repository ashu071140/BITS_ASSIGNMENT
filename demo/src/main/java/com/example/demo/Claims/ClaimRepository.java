package com.example.demo.Claims;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

    Optional<Claim> findByVINAndInsuranceNo(String VIN, long insuranceNo);
    Optional<Claim> findByInsuranceNo(long insuranceNo);


}

