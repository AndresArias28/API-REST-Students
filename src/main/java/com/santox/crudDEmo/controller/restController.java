package com.santox.crudDEmo.controller;

import com.santox.crudDEmo.dao.StudentDAO;
import com.santox.crudDEmo.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class restController {

    private StudentDAO studentDAO;

    public restController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping("/students")
    public List<Student> getStudentList(){
        return studentDAO.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        //verificar el id en la lista de estudiantes
        isPresenId(studentId);
        return studentDAO.findById(studentId);
    }

    @PostMapping("/students")
    public Student creatMultipleStudents(@RequestBody Student student) {
       return studentDAO.save(student);
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudentByStudentId(@PathVariable int studentId){
        isPresenId(studentId);
        studentDAO.deleteStudent(studentId);
        return "Student deleted";
    }

    private void verificateId(int studentId) {
        if(studentId >= studentDAO.findAll().size()  || studentId <= 0  ){
            throw new StudentNotFoundException("Student ID not found: " +studentId);
        }
    }

    private void isPresenId(int studentId) {
        List<Student> studentsList = studentDAO.findAll();
        boolean foundStudent = studentsList.stream().anyMatch(student -> student.getId() == studentId);
        if(!foundStudent){
            throw new StudentNotFoundException("Student ID not found: " + studentId);
        }
    }
}
