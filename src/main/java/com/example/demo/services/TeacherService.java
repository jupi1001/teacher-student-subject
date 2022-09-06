package com.example.demo.services;

import com.example.demo.entities.Teacher;
import com.example.demo.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public Teacher findTeacherById(Long id){
        return teacherRepository.findByTeacherId(id);
    }

    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher updateTeacher(Long teacherId, Teacher teacher) {
        Teacher teacherTemp = teacherRepository.findByTeacherId(teacherId);

        if (Objects.nonNull(teacher.getFirstName()) && !"".equalsIgnoreCase(teacher.getFirstName())) {
            teacherTemp.setFirstName(teacherTemp.getFirstName());
        }
        if (Objects.nonNull(teacher.getLastName()) && !"".equalsIgnoreCase(teacher.getLastName())) {
            teacherTemp.setLastName(teacher.getLastName());
        }
        if (Objects.nonNull(teacher.getBirthday())) {
            teacher.setBirthday(teacher.getBirthday());
        }

        return teacherRepository.save(teacherTemp);
    }

    public void deleteTeacherById(Long teacherId) {
        Teacher teacherTemp = teacherRepository.findByTeacherId(teacherId);

        if(Objects.nonNull( teacherTemp)) {
            teacherRepository.deleteById(teacherId);
        }
    }
}
