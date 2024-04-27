package edu.miu.cs.cs489project.cs489ProjectBackend.dto.response;

import edu.miu.cs.cs489project.cs489ProjectBackend.domain.CustomerInfo;

import lombok.Data;

@Data
public class CustomerDto {
    Long id;
    String username;
    CustomerInfo customerInfo;
//    List<DVD> requests;
//    List<DVD> DVDsAtHome;
//    List<DVD> watchList;
//    List<Subscription> subscriptions;

}
