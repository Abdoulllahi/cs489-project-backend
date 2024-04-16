package edu.miu.cs.cs489project.cs489ProjectBackend.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "subscriptions")
public class Subscription {

    @Id
    private int id;
    private String name;
    private Integer numberOfDVDPerMonth;
    private Integer numberOfDVDAtHome;
    private Double pricePerMonth;

    @ManyToMany
    @JoinTable(
                name = "customer_subscription",
                joinColumns = {@JoinColumn(name = "subscription_id")},
                inverseJoinColumns = {@JoinColumn(name = "customer_id")}
    )
    List<Customer> subscribers;


}
