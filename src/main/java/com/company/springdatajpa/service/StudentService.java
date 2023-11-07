package com.company.springdatajpa.service;

import com.company.springdatajpa.entity.Student;
import com.company.springdatajpa.reopistory.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deletestudent(Integer id) {
         studentRepository.deleteById(id);
    }

    public Optional<Student> getById(Integer id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Integer id, Student student) {
        Optional<Student>foundedStudent=studentRepository.findById(id);
        if (foundedStudent.isPresent()){
            Student newStudent=foundedStudent.get();
            newStudent.setName(student.getName());
            newStudent.setSurname(student.getSurname());
            newStudent.setStudentNumber(student.getStudentNumber());
            newStudent.setDateOfBirth(student.getDateOfBirth());
            return studentRepository.save(newStudent);
        }
        return null;
    }
}
