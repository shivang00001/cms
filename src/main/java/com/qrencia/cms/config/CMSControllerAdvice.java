package com.qrencia.cms.config;

import com.qrencia.cms.exception.CourseNotFoundException;
import com.qrencia.cms.exception.TeacherNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CMSControllerAdvice {

    @ExceptionHandler(TeacherNotFoundException.class)
    public ResponseEntity<String> handlingTeacherNotFound(Exception ex){
     return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<String> handlingCourseNotFound(Exception ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handlingInvalidArgument(MethodArgumentNotValidException ex){
        return new ResponseEntity<>(ex.getDetailMessageArguments()[1].toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handlingAllException(Exception ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}