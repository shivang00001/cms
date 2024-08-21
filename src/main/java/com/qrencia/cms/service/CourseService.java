package com.qrencia.cms.service;

import com.qrencia.cms.dto.CreateCourseRequest;
import com.qrencia.cms.entity.Course;
import com.qrencia.cms.entity.Student;
import com.qrencia.cms.entity.Teacher;
import com.qrencia.cms.exception.CourseNotFoundException;
import com.qrencia.cms.exception.TeacherNotFoundException;
import com.qrencia.cms.repository.CourseRepository;
import com.qrencia.cms.repository.StudentRepository;
import com.qrencia.cms.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public Long addCourse(CreateCourseRequest course, Long teacherId) {

        Optional<Teacher> teacherOptional = teacherRepository.findById(teacherId);
        if (teacherOptional.isEmpty()) {
            throw new TeacherNotFoundException();
        }

        Course courseEntity = new Course(course);
        courseEntity.setTeacherId(teacherId);
        courseRepository.save(courseEntity);
        Teacher teacher = teacherOptional.get();
        teacher.setCourseCount(teacher.getCourseCount() + 1);
        teacherRepository.save(teacher);
        return courseEntity.getId();
    }

    public List<Course> getAllCourses(Long teacherId) {

        return courseRepository.findByTeacherId(teacherId);
    }

    public void enrollStudents(Long teacherId, List<Long> studentId, Long courseId) {
        Optional<Course> courseOptional = courseRepository.findByIdAndTeacherId(courseId, teacherId);
        if (courseOptional.isEmpty()) {
            throw new CourseNotFoundException();
        }
        List<Student> studentsList = studentRepository.findByIdInAndTeacherId(studentId, teacherId);
        if (!studentsList.isEmpty()) {
            String studentIds = "";
            for (Student student : studentsList) {
                studentIds = student.getId() + ",";
            }
            studentIds = studentIds.substring(0,studentIds.length());
            Course course = courseOptional.get();
            String courseStudents = course.getStudentId();
            if(StringUtils.hasLength(courseStudents)){
                studentIds = courseStudents+","+studentIds;
            }
            course.setStudentId(studentIds);
            courseRepository.save(course);
        }

    }
}
