package com.demo.demo_student_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class studentController {
    @Autowired
    private studentService studentService;

    @GetMapping
    public List<student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<student> getStudentById(@PathVariable Long id) {
        Optional<student> user = studentService.getStudentById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public student createStudent(@RequestBody student user) {
        return studentService.createStudent(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<student> updateStudent(@PathVariable Long id, @RequestBody student studentDetails) {
        try {
        	student updatedStudent = studentService.updateStudent(id, studentDetails);
            return ResponseEntity.ok(updatedStudent);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}

