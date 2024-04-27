package edu.miu.cs.cs489project.cs489ProjectBackend.dto.request;

import lombok.Data;

@Data
public class AddSubscriptionRequest {

    private Long customerId;
    private String subscriptionName;
    private String paymentMethod;
}
