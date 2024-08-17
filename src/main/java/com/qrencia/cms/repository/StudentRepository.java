package com.qrencia.cms.repository;

import com.qrencia.cms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    Optional<Student> findByName(String name);
    List<Student> findByIdInAndTeacherId(List<Long> studentIds, Long teacherId);

}
