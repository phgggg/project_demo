package com.demo.student_management.repository;
import com.demo.student_management.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{
Optional<UserInfo> findByName(String username);
}
