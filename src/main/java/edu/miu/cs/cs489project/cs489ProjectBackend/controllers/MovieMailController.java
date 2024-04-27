package edu.miu.cs.cs489project.cs489ProjectBackend.controllers;

import edu.miu.cs.cs489project.cs489ProjectBackend.dto.request.AddSubscriptionRequest;
import edu.miu.cs.cs489project.cs489ProjectBackend.dto.request.RemoveSubscriptionRequest;
import edu.miu.cs.cs489project.cs489ProjectBackend.dto.response.*;
import edu.miu.cs.cs489project.cs489ProjectBackend.service.MovieMailService;
import edu.miu.cs.cs489project.cs489ProjectBackend.service.DVDService;
import edu.miu.cs.cs489project.cs489ProjectBackend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/admin")
public class MovieMailController {



    private final MovieMailService movieMailService;
    private final DVDService dvdService;
    private final SubscriptionService subscriptionService;

    @Autowired
    public MovieMailController(MovieMailService movieMailService, @Qualifier("DVDServiceImplementation") DVDService dvdService,
    SubscriptionService subscriptionService) {
        this.movieMailService = movieMailService;
        this.dvdService = dvdService;
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/customers")
    public List<CustomerDto> getCustomers() {
        return movieMailService.getAllCustomers();
    }

    @GetMapping("/dvds")
    public List<DVDDto> getAllDVDs() {
        return dvdService.getAllDVDs();
    }

    @GetMapping("/subscriptions")
    public List<SubscriptionDto> getAllSubscriptions() {
        return  subscriptionService.getAllSubscriptions();
    }

    @PostMapping("/add-subscription")
    public AddSubscriptionResponse addSubscription(@RequestBody AddSubscriptionRequest request) {

        AddSubscriptionResponse response = new AddSubscriptionResponse();
        boolean success = movieMailService.addSubscription(request.getCustomerId(), request.getSubscriptionName(), request.getPaymentMethod());

        if (success) {
            response.setSuccess(true);
            response.setMessage("Subscription added successfully");
        } else {
            response.setSuccess(false);
            response.setMessage("Failed to add subscription");
        }

        return response;
    }

    @DeleteMapping("/remove-subscription")
    public RemoveSubscriptionResponse removeSubscription(@RequestBody RemoveSubscriptionRequest request) {

        RemoveSubscriptionResponse response = new RemoveSubscriptionResponse();
        boolean success = movieMailService.removeSubscription(request.getCustomerId(), request.getSubscriptionName());

        if (success) {
            response.setSuccess(true);
            response.setMessage("Subscription removed successfully");
        } else {
            response.setSuccess(false);
            response.setMessage("Failed to remove subscription");
        }

        return response;
    }

    @DeleteMapping("/customers/{customerId}")
    public String removeCustomer(@PathVariable Long customerId) {
        boolean removed = movieMailService.deleteCustomer(customerId);
        if (removed) {
            return "Customer with ID " + customerId + " has been removed.";
        } else {
            return "Customer with ID " + customerId + " not found.";
        }
    }
}
