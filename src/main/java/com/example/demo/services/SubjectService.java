package com.example.demo.services;

import com.example.demo.entities.Subject;
import com.example.demo.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject saveSubject(Subject subject){
        return subjectRepository.save(subject);
    }

    public Subject findSubjectById(Long id){
        return subjectRepository.findBySubjectId(id);
    }

    public List<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject updateSubject(Long subjectId, Subject subject) {
        Subject subjectTemp = subjectRepository.findBySubjectId(subjectId);

        if (Objects.nonNull(subject.getName()) && !"".equalsIgnoreCase(subject.getName())) {
            subjectTemp.setName(subject.getName());
        }

        return subjectRepository.save(subjectTemp);
    }

    public void deleteSubjectById(Long subjectId) {
        Subject subjectTemp = subjectRepository.findBySubjectId(subjectId);

        if(Objects.nonNull( subjectTemp)) {
            subjectRepository.deleteById(subjectId);
        }
    }
}
