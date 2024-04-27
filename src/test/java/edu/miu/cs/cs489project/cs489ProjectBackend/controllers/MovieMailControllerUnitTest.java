package edu.miu.cs.cs489project.cs489ProjectBackend.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import edu.miu.cs.cs489project.cs489ProjectBackend.dto.response.CustomerDto;
import edu.miu.cs.cs489project.cs489ProjectBackend.service.MovieMailService;

@SpringBootTest
public class MovieMailControllerUnitTest {

    @Mock
    private MovieMailService movieMailService;

    @InjectMocks
    private MovieMailController movieMailController;

    private MockMvc mockMvc;

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

        // Set up MockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(movieMailController).build();

        // Perform GET request
        mockMvc.perform(get("/api/v1/admin/customers"))
                // Validate status code
                .andExpect(status().isOk())
                // Validate content type
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // Validate response body
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].username").value("john_doe"));

        // Verify that service method was called
        verify(movieMailService, times(1)).getAllCustomers();
    }
}
