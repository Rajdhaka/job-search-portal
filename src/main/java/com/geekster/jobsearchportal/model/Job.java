package com.geekster.jobsearchportal.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Title must not be blank")
    private String title;

    private String description;

    @NotBlank(message = "Location must not be blank")
    private String location;

    private Double salary;

    private String companyName;

    @Pattern(regexp = "\\b[A-Z][a-z]*( [A-Z][a-z]*)*\\b")
    private String employerName;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private LocalDate appliedDate;
}
