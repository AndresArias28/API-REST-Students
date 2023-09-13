package com.santox.crudDEmo.dao;

import com.santox.crudDEmo.entity.Student;

import java.util.List;

public interface StudentDAO {
    Student save(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void updateStudent(Student student);
    void deleteStudent(int id);
    int deleteAllStudent();

}
