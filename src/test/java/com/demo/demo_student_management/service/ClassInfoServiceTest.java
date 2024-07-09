package com.demo.demo_student_management.service;

import com.demo.student_management.entity.ClassInfoEntity;
import com.demo.student_management.repository.ClassInfoRepository;
import com.demo.student_management.service.ClassInfoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClassInfoServiceTest {
    @Mock
    ClassInfoRepository classInfoRepository;
    @InjectMocks
    ClassInfoService classInfoService;

    @Test
    void testFindStudentsByClassId_ReturnStudentExists() {
        Integer classId = 1;


        Object[] student1 = new ClassInfoEntity[]{new ClassInfoEntity(1, classId, 1)};
        Object[] student2 = new ClassInfoEntity[]{new ClassInfoEntity(2, classId, 2)};
        List<Object[]> expectedStudents = new ArrayList<>();
        expectedStudents.add(student1);
        expectedStudents.add(student2);

        when(classInfoRepository.findAllStudentByClassId(classId)).thenReturn(expectedStudents);


        List<Object[]> actualStudents = classInfoService.findStudentsByClassId(classId);


        assertNotNull(actualStudents);
        assertEquals(expectedStudents.size(), actualStudents.size());


        assertEquals(expectedStudents.get(0)[0], actualStudents.get(0)[0]);
        assertEquals(expectedStudents.get(1)[0], actualStudents.get(1)[0]);

        verify(classInfoRepository, times(1)).findAllStudentByClassId(classId);
    }

    @Test
    void testFindClassesOfStudentId_ReturnClassExists() {
        Integer id = 1;

        Object[] class1 = new ClassInfoEntity[]{new ClassInfoEntity(1, 1, id)};
        Object[] class2 = new ClassInfoEntity[]{new ClassInfoEntity(2, 2, id)};
        List<Object[]> expectedClasses = new ArrayList<>();
        expectedClasses.add(class1);
        expectedClasses.add(class2);

        when(classInfoRepository.findAllClassByStudentId(id)).thenReturn(expectedClasses);


        List<Object[]> actualClasses = classInfoService.findClassesOfStudentId(id);


        assertNotNull(actualClasses);
        assertEquals(expectedClasses.size(), actualClasses.size());


        assertEquals(expectedClasses.get(0)[0], actualClasses.get(0)[0]);
        assertEquals(expectedClasses.get(1)[0], actualClasses.get(1)[0]);

        verify(classInfoRepository, times(1)).findAllClassByStudentId(id);
    }

}
