package com.demo.student_management.service;

import com.demo.student_management.entity.ClassEntity;
import com.demo.student_management.entity.StudentEntity;
import com.demo.student_management.repository.ClassRepository;
import com.demo.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private StudentRepository studentRepository;
    public List<ClassEntity> getAllClass() {
        return classRepository.findAll();
    }

    public Set<StudentEntity> getStudentList(Integer id) {
        return studentRepository.studentList(id);
    }

    public Optional<ClassEntity> getClassById(Integer id) {
        return classRepository.findById(id);
    }

    public ClassEntity createClass(ClassEntity student) {
        return classRepository.save(student);
    }

    public ClassEntity updateClass(Integer id, ClassEntity classDetails) {
        ClassEntity stud = classRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        stud.setClassName(classDetails.getClassName());
        return classRepository.save(stud);
    }

    public void deleteClass(Integer id) {
        classRepository.deleteById(id);
    }
}
