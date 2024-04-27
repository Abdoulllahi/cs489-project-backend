package edu.miu.cs.cs489project.cs489ProjectBackend.repository;

import edu.miu.cs.cs489project.cs489ProjectBackend.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Optional<Subscription> findByName(String subscriptionName);
}
