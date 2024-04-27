package edu.miu.cs.cs489project.cs489ProjectBackend.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListMapper <T, E>{

    private final ModelMapper modelMapper;

    @Autowired
    public ListMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<?> mapList(List<T> list, E convertTo) {

        return list
                .stream()
                .map(element -> modelMapper.map(element, convertTo.getClass()))
                .toList();
    }
}
