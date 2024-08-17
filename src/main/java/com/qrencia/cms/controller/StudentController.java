package com.qrencia.cms.controller;

import com.qrencia.cms.entity.Student;
import com.qrencia.cms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestParam String name, @RequestParam Long teacherId) {
        Long studentID = studentService.addStudent(name, teacherId);
        return new ResponseEntity<>("Student added with id -" + studentID, HttpStatus.CREATED);

    }
}
