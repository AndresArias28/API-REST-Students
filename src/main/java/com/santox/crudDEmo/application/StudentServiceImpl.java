package com.santox.crudDEmo.application;

import com.santox.crudDEmo.domain.StudentDAO;
import com.santox.crudDEmo.domain.StudentService;
import com.santox.crudDEmo.domain.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

/*    @Transactional
    @Override
    public Student save(Student student) {
        return studentDAO.save(student);
    }*/

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

    @Override
    public void saveStudent(Student student) {
        studentDAO.save(student);
    }

    @Override
    public void updateStudent(int id, Student student) {
        studentDAO.updateStudent(id, student);
    }
}


