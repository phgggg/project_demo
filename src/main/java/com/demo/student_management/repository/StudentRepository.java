package com.demo.student_management.repository;
import com.demo.student_management.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    @Query(value = "SELECT student.* FROM \n" +
            "student join class_info on student.id = class_info.id\n" +
            "\t\tjoin class on class_info.classID = class.classID\n" +
            "where class.classID = ?\n" +
            "order by student.id asc", nativeQuery = true)
    Set<StudentEntity> studentList(Integer a);

}
