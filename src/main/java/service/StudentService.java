package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.StudentEntity;
import repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> getAllStudent() {
        return studentRepository.findAll();
    }

    public Optional<StudentEntity> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public StudentEntity createStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    public StudentEntity updateStudent(Long id, StudentEntity studentDetails) {
    	StudentEntity stud = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        stud.setFirstName(studentDetails.getFirstName());
        stud.setLastname(studentDetails.getLastname());
        stud.setStudentID(studentDetails.getStudentID());
        stud.setDepartment(studentDetails.getDepartment());
        stud.setMajor(studentDetails.getMajor());
        stud.setCountry(studentDetails.getCountry());
        return studentRepository.save(stud);
    }

    public void deleteStudent(Long id) {
    	studentRepository.deleteById(id);
    }
}
