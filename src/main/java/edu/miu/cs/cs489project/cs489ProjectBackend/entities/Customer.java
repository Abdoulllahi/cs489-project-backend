package edu.miu.cs.cs489project.cs489ProjectBackend.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "customers")
public class Customer {

    @Id
    private Long id;
    private String username;
    private String password;

    @Embedded
    private CustomerInfo customerInfo;

    @ManyToMany(mappedBy = "customer_id")
    private List<Subscription> subscriptions;

//    @OneToMany
//    private List<DVD> watchList;
//
//    @OneToMany
//    private List<DVD> requests;
//
//    @OneToMany
//    private List<DVD> DVDsAtHome;






}
