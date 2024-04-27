package edu.miu.cs.cs489project.cs489ProjectBackend.dto.response;

import lombok.Data;

@Data
public class DVDDto {
    private Long id;
    private String scanCode;
    private String title;
    private String genre;
}
