package edu.miu.cs.cs489project.cs489ProjectBackend.repository;

import edu.miu.cs.cs489project.cs489ProjectBackend.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
