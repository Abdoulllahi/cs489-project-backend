package edu.miu.cs.cs489project.cs489ProjectBackend.entities;

import lombok.Data;

import java.util.List;

@Data
public class CRMSystem {

    private List<CustomerInfo> customerInfos;

    public void addCustomerInfo(CustomerInfo customerInfo) {
        customerInfos.add(customerInfo);
    }
}
