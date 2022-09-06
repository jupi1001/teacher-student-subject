package com.example.demo.controller;

import com.example.demo.entities.Subject;
import com.example.demo.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/")
    public Subject saveSubject(@RequestBody Subject subject){
        return subjectService.saveSubject(subject);
    }

    @GetMapping("/{id}")
    public  Subject findSubjectById(@PathVariable Long id){
        return subjectService.findSubjectById(id);
    }

    @GetMapping("/")
    public List<Subject> findAllStudents(){
        return subjectService.findAllSubjects();
    }

    @PutMapping("/{subjectId}")
    public Subject updateSubject(@PathVariable Long subjectId,@RequestBody Subject subject){
        return subjectService.updateSubject(subjectId,subject);
    }

    @DeleteMapping("/{subjectId}")
    private void deleteSubjectById(@PathVariable Long subjectId){
        subjectService.deleteSubjectById(subjectId);
    }
}
