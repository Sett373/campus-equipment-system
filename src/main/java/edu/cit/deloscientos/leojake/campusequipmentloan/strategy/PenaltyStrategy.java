package edu.cit.deloscientos.leojake.campusequipmentloan.strategy;
import edu.cit.deloscientos.leojake.campusequipmentloan.entity.Loan;
public interface PenaltyStrategy {
    double calculatePenalty(Loan loan);
}