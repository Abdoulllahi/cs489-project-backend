package edu.miu.cs.cs489project.cs489ProjectBackend.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import edu.miu.cs.cs489project.cs489ProjectBackend.dto.response.CustomerDto;
import edu.miu.cs.cs489project.cs489ProjectBackend.service.MovieMailService;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieMailControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieMailService movieMailService;

    @Test
    public void testGetCustomers() throws Exception {
        // Mocking service response
        List<CustomerDto> customers = new ArrayList<>();
        // Add sample customer data to the list
        CustomerDto customer1 = new CustomerDto();
        customer1.setId(1L);
        customer1.setUsername("john_doe");
        customers.add(customer1);

        // Stubbing service method
        when(movieMailService.getAllCustomers()).thenReturn(customers);

        // Perform GET request
        mockMvc.perform(get("/api/v1/admin/customers"))
                // Validate status code
                .andExpect(status().isOk())
                // Validate content type
                .andExpect(content().contentType("application/json"))
                // Validate response body
                .andExpect(jsonPath("$").isArray());

        // Verify that service method was called
        verify(movieMailService, times(1)).getAllCustomers();
    }
}

