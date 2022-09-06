package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subjectId;

    private String name;

    @ManyToMany(mappedBy = "subjects")
    Set<Student> students;

    //Many subjects to one teacher
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacherId" )
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Teacher teacher;
    // getters and setters

}
