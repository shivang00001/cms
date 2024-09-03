package com.qrencia.cms.exception;

public class TeacherNotFoundException extends RuntimeException {
 public TeacherNotFoundException(){
     super("Teacher Not Found");
 }
}