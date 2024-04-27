package edu.miu.cs.cs489project.cs489ProjectBackend.service;

import edu.miu.cs.cs489project.cs489ProjectBackend.dto.response.DVDDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DVDService {

    List<DVDDto> getAllDVDs();
}
