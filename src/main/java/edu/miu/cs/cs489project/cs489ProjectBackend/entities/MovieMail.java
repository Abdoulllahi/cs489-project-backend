package edu.miu.cs.cs489project.cs489ProjectBackend.entities;

import lombok.Data;

import java.util.List;

@Data
public class MovieMail {

    private List<Subscription> subscriptions;
    private List<Customer> customers;
    private List<DVD> dvdCatalog;
    private CRMSystem crmSystem;
}
