package com.santox.crudDEmo.domain.entity;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    void updateStudent(int id, Student student);

    void deleteStudent(int id);

    List<Student> findByLastName(String lastName);

}
