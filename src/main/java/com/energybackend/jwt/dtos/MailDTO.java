package com.energybackend.jwt.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data  @AllArgsConstructor
public class MailDTO {
    private String to;
    private String code;
}
