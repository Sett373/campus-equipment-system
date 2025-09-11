package edu.cit.deloscientos.leojake.campusequipmentloan.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_id", nullable = false)
    @NotNull(message = "Equipment is required")
    private Equipment equipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    @NotNull(message = "Student is required")
    private Student student;

    @NotNull(message = "Start date is required")
    @Column(nullable = false)
    private LocalDate startDate;

    @NotNull(message = "Due date is required")
    @Column(nullable = false)
    private LocalDate dueDate;

    @Column
    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status is required")
    @Column(nullable = false)
    private LoanStatus status = LoanStatus.ACTIVE;

    @Column
    private Double penaltyAmount = 0.0;

    // Default constructor
    public Loan() {}

    // Constructor with parameters
    public Loan(Equipment equipment, Student student, LocalDate startDate, LocalDate dueDate) {
        this.equipment = equipment;
        this.student = student;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.status = LoanStatus.ACTIVE;
        this.penaltyAmount = 0.0;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    public Double getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(Double penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    // Utility methods
    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate) && status == LoanStatus.ACTIVE;
    }

    public boolean isActive() {
        return status == LoanStatus.ACTIVE;
    }

    public boolean isReturned() {
        return status == LoanStatus.RETURNED;
    }

    public long getDaysOverdue() {
        if (!isOverdue() && status != LoanStatus.RETURNED) {
            return 0;
        }
        LocalDate compareDate = returnDate != null ? returnDate : LocalDate.now();
        return compareDate.isAfter(dueDate) ?
                compareDate.toEpochDay() - dueDate.toEpochDay() : 0;
    }

    public void markAsReturned() {
        this.returnDate = LocalDate.now();
        this.status = LoanStatus.RETURNED;
    }

    public void markAsOverdue() {
        this.status = LoanStatus.OVERDUE;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", equipment=" + (equipment != null ? equipment.getName() : "null") +
                ", student=" + (student != null ? student.getName() : "null") +
                ", startDate=" + startDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                ", status=" + status +
                ", penaltyAmount=" + penaltyAmount +
                '}';
    }
}