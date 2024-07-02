package com.demo_student_management.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.demo_student_management.entity.*;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
