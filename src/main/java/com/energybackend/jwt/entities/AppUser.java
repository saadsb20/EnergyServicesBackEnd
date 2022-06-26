package com.energybackend.jwt.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.Collection;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    private String id;
    private String username;
    private String password;
    private int actived;
    private Collection<AppRole> roles = new ArrayList<>();
    private Code code;
    private String address;
}
