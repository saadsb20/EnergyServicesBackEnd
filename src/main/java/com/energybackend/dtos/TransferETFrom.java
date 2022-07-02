package com.energybackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferETFrom {
    private String From;
    private String To;
    private Long Amount;
}
