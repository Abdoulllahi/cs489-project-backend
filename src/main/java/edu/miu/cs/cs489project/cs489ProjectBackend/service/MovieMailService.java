package edu.miu.cs.cs489project.cs489ProjectBackend.service;

import edu.miu.cs.cs489project.cs489ProjectBackend.domain.Customer;
import edu.miu.cs.cs489project.cs489ProjectBackend.dto.response.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieMailService {
    Customer getCustomerById(Long customerId);
    List<CustomerDto> getAllCustomers();
    Customer createCustomer(Customer customer);
    boolean deleteCustomer(Long customerId);
    boolean addSubscription(Long customerId, String subscriptionName, String paymentMethod);

    boolean removeSubscription(Long customerId, String subscriptionName);
}
