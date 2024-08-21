package com.qrencia.cms.repository;

import com.qrencia.cms.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByTeacherId(Long teacherId);


    Optional<Course> findByIdAndTeacherId(Long CourseId, Long TeacherId);
}
