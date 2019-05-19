package com.katonahcomputing.redisservice.service;

import com.katonahcomputing.redisservice.domain.Student;

import java.util.List;

public interface StudentService {
    void saveAll();

    List<Student> findAll();

    void saveStudent(Student data);

    Student retrieveStudent(String key);

    void updateStudent(Student data);

    void deleteStudent(String key);
}
