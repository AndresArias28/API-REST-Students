package com.santox.crudDEmo.controller;

import com.santox.crudDEmo.entity.Student;
import com.santox.crudDEmo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class restController {

    private StudentService studentService;

    @Autowired
    public restController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public String createStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "Student saved successfully";
    }

    @GetMapping("/students")
    public List<Student> getStudentList(){
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        //verificar el id en la lista de estudiantes
        isPresenId(studentId);
        return studentService.findById(studentId);
    }

    @PutMapping("/students/{studentId}")
    public String updateStudent(@PathVariable  int studentId, @RequestBody Student student){
        studentService.updateStudent(studentId, student);
        return "Student updated successfully";
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudentByStudentId(@PathVariable int studentId){
        isPresenId(studentId);
        studentService.deleteStudent(studentId);
        return "Student deleted";
    }

    private void isPresenId(int studentId) {
        List<Student> studentsList = studentService.findAll();
        boolean foundStudent = studentsList.stream().anyMatch(student -> student.getId() == studentId);
        if(!foundStudent){
            throw new StudentNotFoundException("Student ID not found: " + studentId);
        }
    }



}
