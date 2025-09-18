package edu.cit.deloscientos.leojake.campusequipmentloan.repository;

import edu.cit.deloscientos.leojake.campusequipmentloan.model.Loan;
import edu.cit.deloscientos.leojake.campusequipmentloan.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByStudentAndStatus(Student student, String status);
}