package edu.miu.cs.cs489project.cs489ProjectBackend.entities;


import jakarta.persistence.*;
import lombok.Data;

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

    @OneToMany
    @JoinTable(
            name = "Watch_List",
            joinColumns = {@JoinColumn(name = "dvd_id")},
            inverseJoinColumns = {@JoinColumn(name = "customer_id")})
    private List<DVD> watchList;

    @OneToMany
    @JoinTable(
            name = "Requested_DVDs",
            joinColumns = {@JoinColumn(name = "dvd_id")},
            inverseJoinColumns = {@JoinColumn(name = "customer_id")}
    )
    private List<DVD> requests;

    @OneToMany
    @JoinTable(
            name = "dvds_at_home",
            joinColumns = {@JoinColumn(name = "dvd_id")},
            inverseJoinColumns = {@JoinColumn(name = "customer_id")}
    )
    private List<DVD> DVDsAtHome;

    @ManyToMany
    @JoinTable(
            name = "customer_subscription",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "subscription_id")}
    )
    private List<Subscription> subscriptions;

    public void addToWatchList(DVD dvd) {
        this.watchList.add(dvd);
    }

    public void removeFromWatchList(DVD dvd) {
        this.watchList.remove(dvd);
    }

    public void addToRequests(DVD dvd) {
        this.requests.add(dvd);
    }

    public void removeFromRequests(DVD dvd) {
        this.requests.remove(dvd);
    }

    public void addToDVDsAtHome(DVD dvd) {
        this.DVDsAtHome.add(dvd);
    }

    public void removeFromDVDsAtHome(DVD dvd) {
        this.DVDsAtHome.remove(dvd);
    }
}
