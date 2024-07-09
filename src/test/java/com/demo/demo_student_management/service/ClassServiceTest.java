package com.demo.demo_student_management.service;

import com.demo.student_management.entity.ClassEntity;
import com.demo.student_management.repository.ClassRepository;
import com.demo.student_management.service.ClassService;
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
public class ClassServiceTest {
    @Mock
    ClassRepository classRepository;
    @InjectMocks
    ClassService classService;

    @Test
    void testGetAllClass_ReturnList() {
        // 1. create mock data
        List<ClassEntity> mockClasses = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            mockClasses.add(new ClassEntity());
        }

        // 2. define behavior of Repository
        when(classRepository.findAll()).thenReturn(mockClasses);

        // 3. call service method
        List<ClassEntity> actualClasses = classService.getAllClass();

        // 4. assert the result
        assertThat(actualClasses.size()).isEqualTo(mockClasses.size());

        // 4.1 ensure repository is called
        verify(classRepository).findAll();
    }

    @Test
    void testGetClassById_ReturnClassExists() {

        Integer id = 1;
        ClassEntity classEntity = new ClassEntity();
        classEntity.setClassID(id);

        when(classRepository.findById(id)).thenReturn(Optional.of(classEntity));

        Optional<ClassEntity> result = classService.getClassById(id);

        assertTrue(result.isPresent());
        assertEquals(id, result.get().getClassID());
        verify(classRepository, times(1)).findById(id);
    }

    @Test
    void testGetClassById_ReturnClassDoesNotExists() {

        Integer id = 1;
        ClassEntity classEntity = new ClassEntity();
        classEntity.setClassID(0);

        when(classRepository.findById(id)).thenReturn(Optional.empty());

        Optional<ClassEntity> result = classService.getClassById(id);

        assertFalse(result.isPresent());

        verify(classRepository, times(1)).findById(id);
    }

    @Test
    void testCreateClass_Success() {

        Integer id = 1;
        ClassEntity classEntity = new ClassEntity();
        classEntity.setClassID(id);

        when(classRepository.save(classEntity)).thenReturn(classEntity);

        ClassEntity result = classService.createClass(classEntity);

        assertNotNull(result);
        assertEquals(id, result.getClassID());
        verify(classRepository, times(1)).save(classEntity);
    }

    @Test
    void testCreateClass_Failed() {
        Integer id = 1;
        ClassEntity classEntity = new ClassEntity();
        classEntity.setClassID(id); // Ensure this matches your actual field name in ClassEntity

        when(classRepository.save(classEntity)).thenThrow(new RuntimeException("Database error"));


        Exception exception = assertThrows(RuntimeException.class, () -> {
            classService.createClass(classEntity);
        });

        assertEquals("Database error", exception.getMessage());
        verify(classRepository, times(1)).save(classEntity);
    }


}
