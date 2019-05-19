package com.katonahcomputing.redisservice.service;

import com.katonahcomputing.redisservice.domain.Student;
import com.katonahcomputing.redisservice.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentRepository studentRepository;


    @Override
    public void saveAll() {
        Student engStudent = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
        Student medStudent = new Student("Med2015001", "Gareth Houston", Student.Gender.MALE, 2);
        studentRepository.save(engStudent);
        studentRepository.save(medStudent);
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    @Override
    public void saveStudent(Student data) {
        Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
        studentRepository.save(student);
    }

    @Override
    public Student retrieveStudent(String key) {
        Student retrievedStudent = studentRepository.findById(key).get();
        return retrievedStudent;
    }

    @Override
    public void updateStudent(Student data) {
        Student retrievedStudent = retrieveStudent(data.getId());
        studentRepository.save(retrievedStudent);
    }

    @Override
    public void deleteStudent(String key) {
        studentRepository.deleteById(key);
    }


}
