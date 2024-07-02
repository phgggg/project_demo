package com.demo.demo_student_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentService {
    @Autowired
    private studentRepository studentRepository;

    public List<student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Optional<student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public student createStudent(student student) {
        return studentRepository.save(student);
    }

    public student updateStudent(Long id, student studentDetails) {
    	student stud = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        stud.setFirstName(studentDetails.getFirstName());
        stud.setLastname(studentDetails.getLastname());
        stud.setStudentID(studentDetails.getStudentID());
        stud.setDepartment(studentDetails.getDepartment());
        stud.setMajor(studentDetails.getMajor());
        stud.setCountry(studentDetails.getCountry());
        return studentRepository.save(stud);
    }

    public void deleteStudent(Long id) {
    	studentRepository.deleteById(id);
    }
}
