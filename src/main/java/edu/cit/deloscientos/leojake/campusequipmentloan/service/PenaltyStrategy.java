package edu.cit.deloscientos.leojake.campusequipmentloan.service;

import java.time.LocalDate;

public interface PenaltyStrategy {
    double calculatePenalty(LocalDate dueDate, LocalDate returnDate);
}
