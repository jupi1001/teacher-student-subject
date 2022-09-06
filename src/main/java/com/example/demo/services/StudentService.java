package com.example.demo.services;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Student findStudentById(Long id){
        return studentRepository.findByStudentId(id);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Long studentId, Student student) {
        Student studentTemp = studentRepository.findByStudentId(studentId);

        if (Objects.nonNull(student.getFirstName()) && !"".equalsIgnoreCase(student.getFirstName())) {
            studentTemp.setFirstName(student.getFirstName());
        }
        if (Objects.nonNull(student.getLastName()) && !"".equalsIgnoreCase(student.getLastName())) {
            studentTemp.setLastName(student.getLastName());
        }
        if (Objects.nonNull(student.getBirthday())) {
            studentTemp.setBirthday(student.getBirthday());
        }

        return studentRepository.save(studentTemp);
    }

    public void deleteStudentById(Long studentId) {
        Student studentTemp = studentRepository.findByStudentId(studentId);

        if(Objects.nonNull( studentTemp)) {
            studentRepository.deleteById(studentId);
        }
    }
}
