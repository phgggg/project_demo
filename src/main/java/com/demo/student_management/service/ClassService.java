package com.demo.student_management.service;

import com.demo.student_management.entity.ClassEntity;
import com.demo.student_management.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public List<ClassEntity> getAllClass() {
        return classRepository.findAll();
    }

    public Optional<ClassEntity> getClassById(Integer id) {
        return classRepository.findById(id);
    }

    public ClassEntity createClass(ClassEntity classObj) {
        return classRepository.save(classObj);
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
