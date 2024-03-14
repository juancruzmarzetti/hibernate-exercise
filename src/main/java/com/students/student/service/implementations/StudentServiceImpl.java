package com.students.student.service.implementations;

import com.students.student.model.Student;
import com.students.student.repository.IStudentRepository;
import com.students.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {
    private final IStudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> searchById(Long id){
        return studentRepository.findById(id);
    }

    @Override
    public Student saveStudent(Student student){
        if(student != null){
            return studentRepository.save(student);
        }
        return new Student();
    }

    @Override
    public String deleteById(Long id){
        String response = "The student has been deleted successfully from the database!";
        if(studentRepository.findById(id).isPresent()){
            studentRepository.deleteById(id);
            return response;
        }
        response = "The student doesn´t exist in the database";
        return response;
    }

    @Override
    public String updateStudent(Student student){
        String response = "The student has been updated successfully in the database!";
        Long studentId = student.getId();
        if(studentRepository.findById(studentId).isPresent()){
            studentRepository.deleteById(studentId);
            Student studentSaved = studentRepository.save(student);
            return response + " The updated student´s id is: " + studentSaved.getId();
        }
        response = "The student doesn´t exist in the database";
        return response;
    }

}
