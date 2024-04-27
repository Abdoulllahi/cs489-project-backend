package edu.miu.cs.cs489project.cs489ProjectBackend.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer numberOfDVDPerMonth;
    private Integer numberOfDVDAtHome;
    private Double pricePerMonth;

    @ManyToMany(mappedBy = "subscriptions")
    List<Customer> subscribers;


}
