package com.santox.crudDEmo.ui.controller;

import com.santox.crudDEmo.application.exceptions.Verification;
import com.santox.crudDEmo.domain.entity.Student;
import com.santox.crudDEmo.application.service.StudentService;
import com.santox.crudDEmo.application.exceptions.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class restController {

    private StudentService studentService;

    @Autowired
    public restController(StudentService studentService) {
        this.studentService = studentService;
    }

    /*@PostMapping("/students")
    public String createStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "Student saved successfully";
    }*/

    @GetMapping("/students")
    public List<Student> getStudentList(){
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Optional<Student> getStudentById(@PathVariable int studentId){
        //verificar el id en la lista de estudiantes
        Verification ver = new Verification(studentService);
        ver.isPresenId(studentId);
        return studentService.findById(studentId);
    }
/*
    @PutMapping("/students/{studentId}")
    public String updateStudent(@PathVariable  int studentId, @RequestBody Student student){
        studentService.updateStudent(studentId, student);
        return "Student updated successfully";
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudentByStudentId(@PathVariable int studentId){
        Verification ver = new Verification(studentService);
        ver.isPresenId(studentId);
        //isPresenId(studentId);
        studentService.deleteStudent(studentId);
        return "Student deleted";
    }

    @GetMapping("/students/ln{lastName}")
    public List<Student> getStudentsbyLastName(@PathVariable String lastName){
        return studentService.findByLastName(lastName);
    }*/

}
