package com.example.demo.Claims;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Claim {
        @SequenceGenerator(
                name = "claim_sequence",
                sequenceName = "claim_sequence",
                allocationSize = 1
        )
        @Id
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "claim_sequence"
        )
        private long claimId;
        private long VIN;
        private long insuranceNo;
        private String firstName;
        private String lastName;
        private double claimAmount;


        public Claim(Long VIN, Long insuranceNo, String firstName, String lastName, double claimAmount) {
                this.VIN = VIN;
                this.insuranceNo = insuranceNo;
                this.firstName = firstName;
                this.lastName = lastName;
                this.claimAmount = claimAmount;
        }

        @Override
        public String toString() {
                return "Claim{" +
                        "claimId=" + claimId +
                        ", VIN=" + VIN +
                        ", insuranceNo=" + insuranceNo +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", claimAmount=" + claimAmount +
                        '}';
        }
}
