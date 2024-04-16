package edu.miu.cs.cs489project.cs489ProjectBackend.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class CustomerInfo {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}