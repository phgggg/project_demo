package repository;
import org.springframework.data.jpa.repository.JpaRepository;

import entity.StudentEntity;


public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
