package edu.miu.cs.cs489project.cs489ProjectBackend.service.Implementation;

import edu.miu.cs.cs489project.cs489ProjectBackend.dto.response.SubscriptionDto;
import edu.miu.cs.cs489project.cs489ProjectBackend.repository.SubscriptionRepository;
import edu.miu.cs.cs489project.cs489ProjectBackend.service.SubscriptionService;
import edu.miu.cs.cs489project.cs489ProjectBackend.utils.ListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImplementation implements SubscriptionService {

    SubscriptionRepository subscriptionRepository;
    private ListMapper listMapper;

    @Autowired
    public SubscriptionServiceImplementation(SubscriptionRepository subscriptionRepository, ListMapper listMapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.listMapper = listMapper;
    }

    @Override
    public List<SubscriptionDto> getAllSubscriptions() {
        return listMapper.mapList(subscriptionRepository.findAll(), new SubscriptionDto());
    }
}
