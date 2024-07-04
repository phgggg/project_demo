package com.demo.student_management.service;

import com.demo.student_management.entity.StudentEntity;
import com.demo.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.student_management.entity.*;
import com.demo.student_management.repository.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassRepository classRepository;
    public List<StudentEntity> getAllStudent() {
        return studentRepository.findAll();
    }

    public Set<ClassEntity> getClassList(Integer id) {
        return classRepository.classList(id);
    }

    public Optional<StudentEntity> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public StudentEntity createStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    public StudentEntity updateStudent(Integer id, StudentEntity studentDetails) {
    	StudentEntity stud = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        stud.setFirstName(studentDetails.getFirstName());
        stud.setLastname(studentDetails.getLastname());
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
