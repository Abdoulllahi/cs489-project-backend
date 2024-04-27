package edu.miu.cs.cs489project.cs489ProjectBackend.service;

import edu.miu.cs.cs489project.cs489ProjectBackend.dto.response.SubscriptionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubscriptionService {
    List<SubscriptionDto> getAllSubscriptions();
}
