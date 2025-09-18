package edu.cit.deloscientos.leojake.campusequipmentloan.repository;

import edu.cit.deloscientos.leojake.campusequipmentloan.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}