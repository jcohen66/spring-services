package com.katonahcomputing.redisservice.controller;

import com.katonahcomputing.redisservice.domain.Student;
import com.katonahcomputing.redisservice.service.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("init")
    public void init() {
        studentService.saveAll();
    }

    @GetMapping("displayAll")
    public List<Student> displayAll() {
        return studentService.findAll();
    }

    @GetMapping("display")
    public Student display() {
        return studentService.retrieveStudent("Eng2015001");
    }
}
