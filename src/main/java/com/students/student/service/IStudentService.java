package com.students.student.service;

import com.students.student.model.Student;
import java.util.List;
import java.util.Optional;

public interface IStudentService {
    public List<Student> findAllStudents();
    public Optional<Student> searchById(Long id);
    public Student saveStudent(Student student);
    public String deleteById(Long id);
    public String updateStudent(Student student);
}
