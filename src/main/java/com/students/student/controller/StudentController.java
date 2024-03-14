package com.students.student.controller;

import com.students.student.model.Student;
import com.students.student.service.IStudentService;
import com.students.student.service.implementations.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentController {

    private final IStudentService studentService;
    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> searchById(@PathVariable Long id){
        return studentService.searchById(id);
    }

    @PostMapping("/add")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable Long id){
        return studentService.deleteById(id);
    }
}
