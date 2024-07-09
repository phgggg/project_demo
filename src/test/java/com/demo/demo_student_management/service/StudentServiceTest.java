package com.demo.demo_student_management.service;

import com.demo.student_management.entity.StudentEntity;
import com.demo.student_management.repository.StudentRepository;
import com.demo.student_management.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    void testGetAllStudent_ReturnList() {
        // 1. create mock data
        List<StudentEntity> mockClasses = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            mockClasses.add(new StudentEntity());
        }

        // 2. define behavior of Repository
        when(studentRepository.findAll()).thenReturn(mockClasses);

        // 3. call service method
        List<StudentEntity> actualClasses = studentService.getAllStudent();

        // 4. assert the result
        assertThat(actualClasses.size()).isEqualTo(mockClasses.size());

        // 4.1 ensure repository is called
        verify(studentRepository).findAll();
    }

    @Test
    void testGetStudentById_ReturnStudentExists() {

        Integer id = 1;
        StudentEntity classEntity = new StudentEntity();
        classEntity.setId(id);

        when(studentRepository.findById(id)).thenReturn(Optional.of(classEntity));

        Optional<StudentEntity> result = studentService.getStudentById(id);

        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());
        verify(studentRepository, times(1)).findById(id);
    }

    @Test
    void testGetStudentById_ReturnStudentDoesNotExists() {

        Integer id = 1;
        StudentEntity classEntity = new StudentEntity();
        classEntity.setId(0);

        when(studentRepository.findById(id)).thenReturn(Optional.empty());

        Optional<StudentEntity> result = studentService.getStudentById(id);

        assertFalse(result.isPresent());

        verify(studentRepository, times(1)).findById(id);
    }

    @Test
    void testCreateStudent_Success() {

        Integer id = 1;
        StudentEntity classEntity = new StudentEntity();
        classEntity.setId(id);

        when(studentRepository.save(classEntity)).thenReturn(classEntity);

        StudentEntity result = studentService.createStudent(classEntity);

        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(studentRepository, times(1)).save(classEntity);
    }

    @Test
    void testCreateStudent_Failed() {
        Integer id = 1;
        StudentEntity classEntity = new StudentEntity();
        classEntity.setId(id); // Ensure this matches your actual field name in ClassEntity

        when(studentRepository.save(classEntity)).thenThrow(new RuntimeException("Database error"));


        Exception exception = assertThrows(RuntimeException.class, () -> {
            studentService.createStudent(classEntity);
        });

        assertEquals("Database error", exception.getMessage());
        verify(studentRepository, times(1)).save(classEntity);
    }

    

}
