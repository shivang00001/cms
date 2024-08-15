package com.qrencia.cms.service;

import com.qrencia.cms.entity.Teacher;
import com.qrencia.cms.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public Long addTeacher(String name) {
        Teacher teacher = new Teacher();
        teacher.setName(name);
        return teacherRepository.save(teacher).getId();
    }
}
