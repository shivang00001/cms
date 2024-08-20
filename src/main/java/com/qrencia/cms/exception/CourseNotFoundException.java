package com.qrencia.cms.exception;



public class CourseNotFoundException extends RuntimeException {

 public CourseNotFoundException() {
     super("Course Not Found");
 }
}