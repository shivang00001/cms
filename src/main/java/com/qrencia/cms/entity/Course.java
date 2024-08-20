package com.qrencia.cms.entity;

import com.qrencia.cms.dto.CreateCourseRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private Double cost;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime createdOnDate;
    private String image;
    private Long teacherId;
    private String studentId;


    public Course(CreateCourseRequest createCourseRequest) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        this.title = createCourseRequest.getTitle();
        this.description = createCourseRequest.getDescription();
        this.cost = createCourseRequest.getCost();
        this.status = createCourseRequest.getStatus();

        this.startDate = LocalDateTime.parse(createCourseRequest.getStartDate(), formatter);
        this.endDate = LocalDateTime.parse(createCourseRequest.getEndDate(), formatter);
        this.image = createCourseRequest.getImage();
        this.createdOnDate = LocalDateTime.now();

    }

}
