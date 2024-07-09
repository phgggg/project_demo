package com.demo.student_management.service;

import com.demo.student_management.entity.ClassEntity;
import com.demo.student_management.entity.ClassInfoEntity;
import com.demo.student_management.repository.ClassInfoRepository;
import com.demo.student_management.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassInfoService {
    @Autowired
    private ClassInfoRepository classInfoRepository;

    public List<Object[]> findStudentsByClassId(Integer id) {
        return classInfoRepository.findAllStudentByClassId(id);
    }

    public List<Object[]> findClassesOfStudentId(Integer id) {
        return classInfoRepository.findAllClassByStudentId(id);
    }

}
