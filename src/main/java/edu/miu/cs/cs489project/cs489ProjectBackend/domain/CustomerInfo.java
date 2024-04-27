package edu.miu.cs.cs489project.cs489ProjectBackend.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class CustomerInfo {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}
