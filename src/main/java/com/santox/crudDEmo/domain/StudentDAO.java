package com.santox.crudDEmo.domain;

import com.santox.crudDEmo.domain.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    //List<Student> findByLastName(String lastName);

    String updateStudent(int id, Student student);

    void deleteStudent(int id);

    //int deleteAllStudent();

}
