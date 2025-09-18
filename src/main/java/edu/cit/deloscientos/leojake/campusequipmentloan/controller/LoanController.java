package edu.cit.deloscientos.leojake.campusequipmentloan.controller;

import edu.cit.deloscientos.leojake.campusequipmentloan.model.Equipment;
import edu.cit.deloscientos.leojake.campusequipmentloan.model.Loan;
import edu.cit.deloscientos.leojake.campusequipmentloan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoanController {
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/loans")
    public ResponseEntity<Loan  > createLoan(@RequestBody LoanService loanService) {
        Loan loan = loanService.createLoan(loanService.getStudentId(), loanService.getEquipmentId());
        return ResponseEntity.ok(loan);
    }

    @PostMapping("/loans/{id}/return")
    public ResponseEntity<Loan> returnLoan(@PathVariable Long id) {
        Loan loan = loanService.returnLoan(id);
        return ResponseEntity.ok(loan);
    }

    @GetMapping("/equipment/available")
    public ResponseEntity<List<Equipment>> getAvailableEquipment() {
        List<Equipment> equipment = loanService.getAvailableEquipment();
        return ResponseEntity.ok(equipment);
    }

}