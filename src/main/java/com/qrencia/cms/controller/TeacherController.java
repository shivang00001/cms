package com.qrencia.cms.controller;

import com.qrencia.cms.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<String> addTeacher(@RequestParam String name) {

        Long teacherId =  teacherService.addTeacher(name);
        return new ResponseEntity<>("Teacher added with id -" + teacherId, HttpStatus.CREATED);
    }
}
