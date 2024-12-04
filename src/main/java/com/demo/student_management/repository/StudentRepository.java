package com.demo.student_management.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import com.demo.student_management.entity.StudentEntity;
import java.util.*;

@Component
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    @Query(value = "SELECT id FROM student\n" +
            "where student.id = :studentID", nativeQuery = true)
    Integer findStudentID(Integer studentID);

    @Query(value = "SELECT studentID FROM student\n" +
            "where student.id = :studentID", nativeQuery = true)
    String findByStudentID(String studentID);
}
