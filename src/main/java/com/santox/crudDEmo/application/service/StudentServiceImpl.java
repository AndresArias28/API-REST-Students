package com.santox.crudDEmo.application.service;

import com.santox.crudDEmo.Infrastructure.StudentRepository;
import com.santox.crudDEmo.domain.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepo)
    {
        this.studentRepo = studentRepo;
    }

    @Override
    public Optional<Student> findById(int studentId) {
        return studentRepo.findById(studentId);
    }

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }
/*
    @Transactional
    @Override
    public void deleteStudent(int studentId) {
        studentDAO.deleteStudent(studentId);
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        return studentDAO.findByLastName(lastName);
    }


    @Override
    public void saveStudent(Student student) {
        studentDAO.save(student);
    }

    @Override
    public void updateStudent(int id, Student student) {
        studentDAO.updateStudent(id, student);
    }*/
}


