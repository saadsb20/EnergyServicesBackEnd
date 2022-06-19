package com.energybackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceInput {
    private String privateKey;
    private String Station;
    private String Cable;
    private Long value;
    private String Beneficiary;
}
