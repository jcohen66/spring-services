package com.example.redisserver.service;

import com.example.redisserver.domain.Student;
import com.example.redisserver.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    StudentRepository studentRepository;


    public void saveAll() {
        Student engStudent = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
        Student medStudent = new Student("Med2015001", "Gareth Houston", Student.Gender.MALE, 2);
        studentRepository.save(engStudent);
        studentRepository.save(medStudent);
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public void saveStudent(Student data) {
        Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
        studentRepository.save(student);
    }

    public Student retrieveStudent(String key) {
        Student retrievedStudent = studentRepository.findById(key).get();
        return retrievedStudent;
    }

    public void updateStudent(Student data) {
        Student retrievedStudent = retrieveStudent(data.getId());
        studentRepository.save(retrievedStudent);
    }

    public void deleteStudent(String key) {
        studentRepository.deleteById(key);
    }


}
