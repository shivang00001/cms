package com.qrencia.cms.controller;

import com.qrencia.cms.dto.CreateCourseRequest;
import com.qrencia.cms.entity.Course;
import com.qrencia.cms.repository.CourseRepository;
import com.qrencia.cms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor

public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<String> addCourse(@RequestBody CreateCourseRequest createCourseRequest,
                                            @RequestParam Long teacherId) {

        Long courseId = courseService.addCourse(createCourseRequest, teacherId);
        return new ResponseEntity<>("Course added with id -" + courseId, HttpStatus.CREATED);
    }

    @PostMapping("/enroll-students")
    public ResponseEntity<String> enrollStudents(@RequestParam List<Long> studentIds,
                                                 @RequestParam Long teacherId,
                                                 @RequestParam Long courseId) {
        courseService.enrollStudents(teacherId,studentIds, courseId );
        return new ResponseEntity<>("Students enrolled" , HttpStatus.CREATED);

    }
}
