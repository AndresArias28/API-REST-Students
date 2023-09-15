package com.santox.crudDEmo.application.exceptions;

import com.santox.crudDEmo.application.StudentService;
import com.santox.crudDEmo.domain.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Verification {
    private StudentService studentService;

    @Autowired
    public Verification(StudentService studentService) {
        this.studentService = studentService;
    }

    public void isPresenId(int studentId) {
        List<Student> studentsList = studentService.findAll();
        boolean foundStudent = studentsList.stream().anyMatch(student -> student.getId() == studentId);
        if(!foundStudent){
            throw new StudentNotFoundException("Student ID not found: " + studentId);
        }
    }
}
