package com.demo.demo_student_management.service;

import com.demo.student_management.dto.UserInfo;
import com.demo.student_management.dto.UserInfoDetails;
import com.demo.student_management.entity.ClassEntity;
import com.demo.student_management.repository.UserInfoRepository;
import com.demo.student_management.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class UserInfoServiceTest {

    @Mock
    UserInfoRepository userInfoRepository;
    @InjectMocks
    UserInfoService userInfoService;
    @Test
    void testLoadUserByUsername_ReturnUserExists() {
        // Arrange
        String name = "abcd";
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setPassword("1234");
        userInfo.setRoles("ROLE_ADMIN");

        when(userInfoRepository.findByName(name)).thenReturn(Optional.of(userInfo));

        UserInfoDetails result = userInfoService.loadUserByUsername(name);

        assertNotNull(result);
        assertEquals(name, result.getUsername());
        verify(userInfoRepository, times(1)).findByName(name);
    }

    @Test
    void testLoadUserByUsername_UserNotFound() {

        String name = "nonexistentuser";
        when(userInfoRepository.findByName(name)).thenReturn(Optional.empty());


        assertThrows(UsernameNotFoundException.class, () -> {
            userInfoService.loadUserByUsername(name);
        });

        verify(userInfoRepository, times(1)).findByName(name);
    }
}
