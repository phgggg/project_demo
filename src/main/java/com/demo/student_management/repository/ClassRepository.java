package com.demo.student_management.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import com.demo.student_management.entity.ClassEntity;

@Component
public interface ClassRepository extends JpaRepository<ClassEntity, Integer> {
    @Query(value = "SELECT classID FROM class\n" +
            "where class.classID = :classID", nativeQuery = true)
    Integer findClassID(Integer classID);
}
