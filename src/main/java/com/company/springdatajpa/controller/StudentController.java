package com.company.springdatajpa.controller;

import com.company.springdatajpa.entity.Student;
import com.company.springdatajpa.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @GetMapping("/all")
    public List<Student>getAllStudent(){
        return studentService.getAllStudent();
    }
    @GetMapping("/byId/{id}")
    public Optional<Student> getById(@PathVariable Integer id){
        return studentService.getById(id);
    }
    @PostMapping("/new")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Integer id){
         studentService.deletestudent(id);
    }
    @PutMapping("edit/{id}")
    public Student updateStudent(@PathVariable Integer id,@RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
}
