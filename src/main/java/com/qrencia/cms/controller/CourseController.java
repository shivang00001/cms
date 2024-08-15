package com.qrencia.cms.controller;

import com.qrencia.cms.dto.CreateCourseRequest;
import com.qrencia.cms.entity.Course;
import com.qrencia.cms.repository.CourseRepository;
import com.qrencia.cms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor

public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public String addCourse(@RequestBody CreateCourseRequest createCourseRequest,
                            @RequestParam Long teacherId) {

        Long courseId = courseService.addCourse(createCourseRequest, teacherId);
        return "Course added with id -"+courseId;
    }
}
