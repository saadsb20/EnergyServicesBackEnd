package com.energybackend.jwt.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResp {
    private String id;
    private String username;
    private int actived;
    private String address;
}
