package com.qrencia.cms.service;

import com.qrencia.cms.entity.Student;
import com.qrencia.cms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Long addStudent(String  name, Long teacherId) {
        Optional<Student> studentOptional = studentRepository.findByName(name);
        if (studentOptional.isPresent()) {
            throw new RuntimeException("student already exist");
        }
        Student student = new Student();
        student.setName(name);
        student.setTeacherId(teacherId);
        studentRepository.save(student);
        return student.getId();
    }
}
