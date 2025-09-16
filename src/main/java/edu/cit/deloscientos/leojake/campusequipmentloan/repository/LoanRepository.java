package edu.cit.deloscientos.leojake.campusequipmentloan.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cit.deloscientos.leojake.campusequipmentloan.entity.Loan;
import edu.cit.deloscientos.leojake.campusequipmentloan.entity.LoanStatus;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByStudentIdAndStatus(Long studentId, LoanStatus status);
}