package com.example.demo.controller;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public  Student findStudentById(@PathVariable Long id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/")
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable Long studentId,@RequestBody Student student){
        return studentService.updateStudent(studentId,student);
    }

    @DeleteMapping("/{studentId}")
    private void deleteStudentById(@PathVariable Long studentId){
        studentService.deleteStudentById(studentId);
    }

}
