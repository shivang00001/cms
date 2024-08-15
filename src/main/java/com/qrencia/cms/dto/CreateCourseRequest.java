package com.qrencia.cms.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateCourseRequest {

    private String courseName;
    private String title;
    private String description;
    private Double cost;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String image;

}
