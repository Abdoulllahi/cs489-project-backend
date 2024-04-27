package edu.miu.cs.cs489project.cs489ProjectBackend.dto.response;


import lombok.Data;

import java.util.List;

@Data
public class SubscriptionDto {
    private Long id;
    private String name;
    private Integer numberOfDVDPerMonth;
    private Integer numberOfDVDAtHome;
    private Double pricePerMonth;

    List<CustomerDto> subscribers;
}
