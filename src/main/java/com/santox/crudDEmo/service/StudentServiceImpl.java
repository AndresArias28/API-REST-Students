package com.santox.crudDEmo.service;

import com.santox.crudDEmo.dao.StudentDAO;
import com.santox.crudDEmo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Transactional
    @Override
    public Student save(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public Student findById(int studentId) {
        return studentDAO.findById(studentId);
    }

    @Transactional
    @Override
    public void deleteStudent(int studentId) {
        studentDAO.deleteStudent(studentId);

    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }
}

