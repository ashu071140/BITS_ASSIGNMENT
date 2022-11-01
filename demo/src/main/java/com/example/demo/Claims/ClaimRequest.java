package com.example.demo.Claims;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClaimRequest {

    private long vin;
    private long insuranceNo;
    private boolean json;
}
