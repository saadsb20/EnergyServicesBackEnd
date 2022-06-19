package com.energybackend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Service {
    @Id
    private String ServiceId;
    private String Station;
    private String Cable;
    private Long value;
    private String Beneficiary;

}
