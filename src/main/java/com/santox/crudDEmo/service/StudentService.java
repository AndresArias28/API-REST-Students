package com.santox.crudDEmo.service;

import com.santox.crudDEmo.entity.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);
    Student findById(int studentId);
    void deleteStudent(int studentId);
    List<Student> findAll();
}
