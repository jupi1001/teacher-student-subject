package com.example.demo.repositories;

import com.example.demo.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    Subject findBySubjectId(Long id);
}
