package com.example.demo.controller;


import com.example.demo.entities.Teacher;
import com.example.demo.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/")
    public Teacher saveTeacher(@RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping("/{id}")
    public Teacher findTeacherById(@PathVariable Long id){
        return teacherService.findTeacherById(id);
    }

    @GetMapping("/")
    public List<Teacher> findAllTeachers(){
        return teacherService.findAllTeachers();
    }

    @PutMapping("/{teacherId}")
    public Teacher updateTeacher(@PathVariable Long teacherId,@RequestBody Teacher teacher){
        return teacherService.updateTeacher(teacherId,teacher);
    }

    @DeleteMapping("/{teacherId}")
    private void deleteTeacherById(@PathVariable Long teacherId){
        teacherService.deleteTeacherById(teacherId);
    }
}
