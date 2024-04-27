package edu.miu.cs.cs489project.cs489ProjectBackend.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @Embedded
    private CustomerInfo customerInfo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Watch_List",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "dvd_id")})
    private List<DVD> watchList;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "Requested_DVDs",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "dvd_id")}
    )
    private List<DVD> requests;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "dvds_at_home",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "dvd_id")}
    )
    private List<DVD> DVDsAtHome;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "customer_subscription",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "subscription_id")}
    )
    private List<Subscription> subscriptions;

    public Customer() {
        this.watchList = new ArrayList<>();
        this.requests = new ArrayList<>();
        this.DVDsAtHome = new ArrayList<>();
        this.subscriptions = new ArrayList<>();
    }

}
