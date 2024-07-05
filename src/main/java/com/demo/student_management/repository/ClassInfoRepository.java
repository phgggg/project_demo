package com.demo.student_management.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import com.demo.student_management.entity.ClassEntity;
import com.demo.student_management.entity.ClassInfoEntity;
import com.demo.student_management.entity.StudentEntity;
import java.util.List;
import java.util.Set;


@Component
public interface ClassInfoRepository extends JpaRepository<ClassInfoEntity, Integer> {


    @Query(value = "SELECT count(infoID) FROM class_info\n" +
            "where classID = :classID", nativeQuery = true)
    Integer studentInClassCount(Integer classID);

    @Query(value = "SELECT infoID FROM class_info\n" +
            "where class_info.infoID = :infoID", nativeQuery = true)
    Integer findInfoID(Integer infoID);

    @Query(value = "SELECT student.* FROM " +
            "student join class_info on student.id = class_info.id " +
            "join class on class_info.classID = class.classID " +
            "where class.classID = ? ", nativeQuery = true)
    List<Object[]> findAllStudentByClassId(Integer classID);

    @Query(value = "SELECT class.* FROM " +
            "student join class_info on student.id = class_info.id " +
            "join class on class_info.classID = class.classID " +
            "where student.id = ? ", nativeQuery = true)
    List<Object[]> findAllClassByStudentId(Integer studentID);
}
