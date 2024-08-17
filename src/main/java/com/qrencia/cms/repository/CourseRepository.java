package com.qrencia.cms.repository;

import com.qrencia.cms.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByTeacherId(Long teacherId);


    Optional<Course> findByTeacherIdAndCourse(Long TeacherId, Long CourseId);
}
