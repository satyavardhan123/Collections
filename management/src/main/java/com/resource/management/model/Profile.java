package com.resource.management.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@Data
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Email
    private String email;
    @Pattern(regexp = "[0-9]{10}")
    private String phone;

    @Pattern(message = "Password should be 8 characters long and should contain at least one digit, one uppercase and one lowercase letter", regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")
    private String password;

    @Lob
    private String skillSet;

    @Lob
    private String currentProjectDetail;
    private String currentManagerName;

    @Pattern(regexp = "[0-9]{10}")
    private String currentManagerPhone;

    @Email(message = "Given input is not a valid email") //saying that this field should be an email - validation
    private String currentManagerEmail;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
    private String startDateOfProject;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
    private String endDateOfProject;

    private Boolean isInTraining = false;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Achievement> achievements = new LinkedList<>();
}
