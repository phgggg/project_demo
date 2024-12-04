package com.demo.student_management.service;

import com.demo.student_management.entity.StudentEntity;
import com.demo.student_management.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.student_management.entity.*;
import com.demo.student_management.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private static final Logger log = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> getAllStudent() {
        return studentRepository.findAll();
    }

    public Optional<StudentEntity> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public StudentEntity createStudent(StudentEntity student) {
        String studentInDb = studentRepository.findByStudentID(student.getStudentID());
        if(studentInDb!=null || student.getStudentID().isEmpty()){
            log.info("Id already in db/id null, return null");
            return null;
        }
        String pass = student.getPassword();
        if(pass.length() < 8 || !pass.contains("!") || !pass.contains("A")|| !pass.contains("1") || pass.length() > 30){
            log.info("password is not strong enough, return null");
            return null;
        }
        return studentRepository.save(student);
    }

    public StudentEntity updateStudent(Integer id, StudentEntity studentDetails) {
    	StudentEntity stud = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        stud.setFirstName(studentDetails.getFirstName());
        stud.setLastName(studentDetails.getLastName());
        stud.setStudentID(studentDetails.getStudentID());
        stud.setDepartment(studentDetails.getDepartment());
        stud.setMajor(studentDetails.getMajor());
        stud.setCountry(studentDetails.getCountry());
        return studentRepository.save(stud);
    }

    public void deleteStudent(Integer id) {
    	studentRepository.deleteById(id);
    }
}
