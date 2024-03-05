package com.resource.management.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Entity
public class ProfileRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    private Profile profile;

    @OneToOne(cascade = CascadeType.MERGE)
    private Manager manager;

    private String status = "PENDING";

    private String date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
}
