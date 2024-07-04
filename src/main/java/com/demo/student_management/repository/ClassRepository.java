package com.demo.student_management.repository;

import com.demo.student_management.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public interface ClassRepository extends JpaRepository<ClassEntity, Integer> {
    @Query(value = "SELECT class.* FROM \n" +
            "student join class_info on student.id = class_info.id\n" +
            "\t\tjoin class on class_info.classID = class.classID\n" +
            "where student.id = ?", nativeQuery = true)
    Set<ClassEntity> classList(Integer a);
}
