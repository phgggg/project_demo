package com.demo.student_management.controller;

import com.demo.student_management.entity.ClassEntity;
import com.demo.student_management.entity.StudentEntity;
import com.demo.student_management.service.ClassInfoService;
import com.demo.student_management.service.ClassService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/classes")
public class ClassController {
    @Autowired
    private ClassService classService;
    @Autowired
    private ClassInfoService classInfoService;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public List<ClassEntity> getAllClass() {
        return classService.getAllClass();
    }

    @GetMapping("/{id}/student")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Object[]> getAllStudentOfClass(@PathVariable Integer id) {
        return classInfoService.findStudentsByClassId(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ClassEntity> getClassById(@PathVariable Integer id) {
        Optional<ClassEntity> user = classService.getClassById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ClassEntity createClass(@Valid @RequestBody ClassEntity user) {
        return classService.createClass(user);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ClassEntity> updateClass(@PathVariable Integer id, @RequestBody ClassEntity studentDetails) {
        try {
            ClassEntity updatedClass = classService.updateClass(id, studentDetails);
            return ResponseEntity.ok(updatedClass);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteClass(@PathVariable Integer id) {
        classService.deleteClass(id);
        return ResponseEntity.noContent().build();
    }
}

