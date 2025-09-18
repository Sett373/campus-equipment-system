package edu.cit.deloscientos.leojake.campusequipmentloan.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class DailyPenaltyStrategy implements PenaltyStrategy{
    private static final double PENALTY_PER_DAY = 50.0; // Penalty rate per day

    @Override
    public double calculatePenalty(LocalDate dueDate, LocalDate returnDate) {
        if(returnDate == null || !returnDate.isAfter(dueDate)) {
            return 0.0;
        }
        long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
        return daysLate * PENALTY_PER_DAY;
    }
}
