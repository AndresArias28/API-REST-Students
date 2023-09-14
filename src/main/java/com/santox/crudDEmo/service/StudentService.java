package com.santox.crudDEmo.service;

import com.santox.crudDEmo.entity.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);

    List<Student> findAll();

    Student findById(int studentId);

    void updateStudent(int studentId, Student student);

    void deleteStudent(int studentId);
}
