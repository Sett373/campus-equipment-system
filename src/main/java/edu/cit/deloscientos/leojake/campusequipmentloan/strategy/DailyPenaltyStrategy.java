package edu.cit.deloscientos.leojake.campusequipmentloan.strategy;
import org.springframework.stereotype.Component;

import edu.cit.deloscientos.leojake.campusequipmentloan.entity.Loan;

@Component
public class DailyPenaltyStrategy implements PenaltyStrategy{
    private static final double DAILY_PENALTY_RATE = 50.0; //rate per day

    @Override
    public double calculatePenalty(Loan loan) {
        long daysOverdue = java.time.temporal.ChronoUnit.DAYS.between(loan.getDueDate(), java.time.LocalDate.now());
        return daysOverdue * DAILY_PENALTY_RATE;
    }
}