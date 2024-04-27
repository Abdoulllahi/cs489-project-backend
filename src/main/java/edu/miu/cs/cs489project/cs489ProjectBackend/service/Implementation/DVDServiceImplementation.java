package edu.miu.cs.cs489project.cs489ProjectBackend.service.Implementation;

import edu.miu.cs.cs489project.cs489ProjectBackend.dto.response.DVDDto;
import edu.miu.cs.cs489project.cs489ProjectBackend.repository.DVDRepository;
import edu.miu.cs.cs489project.cs489ProjectBackend.service.DVDService;
import edu.miu.cs.cs489project.cs489ProjectBackend.utils.ListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DVDServiceImplementation implements DVDService {

    private final DVDRepository dvdRepository;
    private ListMapper listMapper;

    @Autowired
    public DVDServiceImplementation(DVDRepository dvdRepository, ListMapper listMapper) {
        this.dvdRepository = dvdRepository;
        this.listMapper = listMapper;
    }

    @Override
    public List<DVDDto> getAllDVDs() {
        return listMapper.mapList(dvdRepository.findAll(), new DVDDto());
    }
}
