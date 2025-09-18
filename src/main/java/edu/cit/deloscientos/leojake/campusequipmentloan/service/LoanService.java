package edu.cit.deloscientos.leojake.campusequipmentloan.service;

import edu.cit.deloscientos.leojake.campusequipmentloan.model.Equipment;
import edu.cit.deloscientos.leojake.campusequipmentloan.model.Loan;
import edu.cit.deloscientos.leojake.campusequipmentloan.model.Student;
import edu.cit.deloscientos.leojake.campusequipmentloan.repository.EquipmentRepository;
import edu.cit.deloscientos.leojake.campusequipmentloan.repository.LoanRepository;
import edu.cit.deloscientos.leojake.campusequipmentloan.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    private static final int MAX_ACTIVE_LOAN_DAYS = 2;
    private static final int LOAN_DURATION_DAYS = 7;
    private final LoanRepository loanRepository;
    private final EquipmentRepository equipmentRepository;
    private final StudentRepository studentRepository;
    private final PenaltyStrategy penaltyStrategy;

    @Autowired
    public LoanService(LoanRepository loaRepository, EquipmentRepository equipmentRepository, StudentRepository studentRepository, PenaltyStrategy penaltyStrategy) {
        this.loanRepository = loaRepository;
        this.equipmentRepository = equipmentRepository;
        this.studentRepository = studentRepository;
        this.penaltyStrategy = penaltyStrategy;
    }

    @Transactional
    public Loan createLoan(Long studentId, Long equipmentId) {
        // Implementation for creating a loan
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));

        Equipment equipment = equipmentRepository.findById(equipmentId).orElseThrow(() -> new RuntimeException("Equipment not found"));

        //check active loan limit
        List<Loan> activeLoans = loanRepository.findByStudentAndStatus(student, "ACTIVE");
        if(activeLoans.size() >= MAX_ACTIVE_LOAN_DAYS) {
            throw new IllegalStateException("Student has reached the maximum number of active loans");
        }

        //check equipment availability
        if(!equipment.isAvailability()) {
            throw new IllegalStateException("Equipment is not available for loan");
        }

        //create loan
        Loan loan = new Loan();
        loan.setStudent(student);
        loan.setEquipment(equipment);
        loan.setStartDate(java.time.LocalDate.now());
        loan.setDueDate(loan.getStartDate().plusDays(LOAN_DURATION_DAYS));
        loan.setStatus("ACTIVE");

        //update equipment availability

        equipment.setAvailability(false);
        equipmentRepository.save(equipment);

        return loanRepository.save(loan);
    }

    public Loan returnLoan(Long id) {
    }

    public List<Equipment> getAvailableEquipment() {
    }
}