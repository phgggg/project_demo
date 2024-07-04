package com.demo.student_management.controller;

import com.demo.student_management.entity.ClassEntity;
import com.demo.student_management.entity.StudentEntity;
import com.demo.student_management.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/hello-world")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public StudentEntity HelloWorld() {
        return new StudentEntity(5, "firstName","firstName","firstName","firstName","firstName","firstName");
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<StudentEntity> getAllStudent() {
        return studentService.getAllStudent();
    }


    @GetMapping("/{id}/classes")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public Set<ClassEntity> getAllClass(@PathVariable Integer id) {
        return studentService.getClassList(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Integer id) {
        Optional<StudentEntity> user = studentService.getStudentById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public StudentEntity createStudent(@Valid @RequestBody StudentEntity user) {
        return studentService.createStudent(user);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable Integer id, @RequestBody StudentEntity studentDetails) {
        try {
        	StudentEntity updatedStudent = studentService.updateStudent(id, studentDetails);
            return ResponseEntity.ok(updatedStudent);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}

