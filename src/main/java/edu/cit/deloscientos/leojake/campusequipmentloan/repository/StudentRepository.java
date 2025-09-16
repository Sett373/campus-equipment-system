package edu.cit.deloscientos.leojake.campusequipmentloan.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cit.deloscientos.leojake.campusequipmentloan.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}