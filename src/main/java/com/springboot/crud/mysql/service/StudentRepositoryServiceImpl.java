package com.springboot.crud.mysql.service;


import com.springboot.crud.mysql.dao.StudentRepository;
import com.springboot.crud.mysql.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StudentRepositoryServiceImpl implements  StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentRepositoryServiceImpl(StudentRepository theStudentRepository) {
        studentRepository = theStudentRepository;
    }

    @Override

    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override

    public Student findById(int rollNum) {
        Optional<Student> result = studentRepository.findById(rollNum);

        Student theStudent = null;
        if(result.isPresent()){
            theStudent = result.get();
        }
        else{
                throw new RuntimeException("Did not find : "+rollNum);
        }
        return theStudent;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteById(int roll_number) {
        studentRepository.deleteById(roll_number);
    }
}
