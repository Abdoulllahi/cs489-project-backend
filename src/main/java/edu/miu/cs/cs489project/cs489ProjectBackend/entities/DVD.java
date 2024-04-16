package edu.miu.cs.cs489project.cs489ProjectBackend.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "DVDs")
public class DVD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String scanCode;
    private String title;
    private String genre;
}
