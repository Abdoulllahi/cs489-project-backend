package edu.miu.cs.cs489project.cs489ProjectBackend.service.Implementation;

import edu.miu.cs.cs489project.cs489ProjectBackend.domain.Customer;
import edu.miu.cs.cs489project.cs489ProjectBackend.domain.Subscription;
import edu.miu.cs.cs489project.cs489ProjectBackend.dto.response.CustomerDto;
import edu.miu.cs.cs489project.cs489ProjectBackend.repository.CustomerRepository;
import edu.miu.cs.cs489project.cs489ProjectBackend.repository.SubscriptionRepository;
import edu.miu.cs.cs489project.cs489ProjectBackend.service.MovieMailService;
import edu.miu.cs.cs489project.cs489ProjectBackend.utils.ListMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieMailServiceImplementation implements MovieMailService {

    private final CustomerRepository customerRepository;
    private final SubscriptionRepository subscriptionRepository;
    private ListMapper listMapper;


    public MovieMailServiceImplementation(CustomerRepository customerRepository, ListMapper listMapper, SubscriptionRepository subscriptionRepository) {
        this.customerRepository = customerRepository;
        this.listMapper = listMapper;
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return listMapper.mapList(customers, new CustomerDto());
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
        return false;
    }


    @Override
    @Transactional
    public boolean addSubscription(Long customerId, String subscriptionName, String paymentMethod) {
        // Step 1: Validate input parameters
        if (customerId == null || subscriptionName == null || paymentMethod == null) {
            return false;
        }

        // Step 2: Check if the customer exists
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isEmpty()) {
            return false;
        }
        Customer customer = optionalCustomer.get();

        Optional<Subscription> optionalSubscription = subscriptionRepository.findByName(subscriptionName);
        if (optionalSubscription.isEmpty()) {
            return false; // Subscription does not exist
        }
        Subscription subscription = optionalSubscription.get();

        boolean paymentProcessed = processPayment(customer, subscription, paymentMethod);
        if (!paymentProcessed) {
            return false; // Payment processing failed
        }

        // Step 5: Add the subscription to the customer's list of subscriptions
        customer.getSubscriptions().add(subscription);
        customerRepository.save(customer);

        return true;
    }

    @Override
    @Transactional
    public boolean removeSubscription(Long customerId, String subscriptionName) {
        // Step 1: Validate input parameters
        if (customerId == null || subscriptionName == null) {
            return false;
        }

        // Step 2: Check if the customer exists
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isEmpty()) {
            return false;
        }
        Customer customer = optionalCustomer.get();

        // Step 3: Find the subscription by name
        Optional<Subscription> optionalSubscription = subscriptionRepository.findByName(subscriptionName);
        if (optionalSubscription.isEmpty()) {
            return false; // Subscription does not exist
        }

        Subscription subscription = optionalSubscription.get();
        if (customer.getSubscriptions().contains(subscription)) {
            customer.getSubscriptions().remove(subscription);
            customerRepository.save(customer);
            return true; // Subscription removed successfully
        } else {
            return false; // Customer does not have this subscription
        }
    }

    private boolean processPayment(Customer customer, Subscription subscription, String paymentMethod) {
        // Simulate processing time (e.g., 10 seconds)
        try {
            Thread.sleep(10000); // 10 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // In a real-world scenario, we would perform actual payment processing here
        // For simplicity, we're assuming payment is successful without any validation
        return true;
    }
}
