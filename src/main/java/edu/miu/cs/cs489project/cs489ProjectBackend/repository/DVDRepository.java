package edu.miu.cs.cs489project.cs489ProjectBackend.repository;

import edu.miu.cs.cs489project.cs489ProjectBackend.domain.DVD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DVDRepository extends JpaRepository<DVD, Long> {
}
