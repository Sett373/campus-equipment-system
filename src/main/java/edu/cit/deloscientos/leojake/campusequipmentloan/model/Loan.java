package edu.cit.deloscientos.leojake.campusequipmentloan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Equipment equipment;
    private Student student;
    private LocalDate startDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private String status;
}
