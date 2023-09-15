package com.santox.crudDEmo.application.service;

import com.santox.crudDEmo.domain.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Optional<Student> findById(int studentId);

    List<Student> findAll();
    /*void saveStudent(Student student);


    void updateStudent(int studentId, Student student);

    void deleteStudent(int studentId);

    List<Student> findByLastName(String lastName);
*/
}
