package com.springboot.crud.mysql.service;

import com.springboot.crud.mysql.dao.StudentDAO;
import com.springboot.crud.mysql.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService {

    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO theStudentDAO) {
        studentDAO = theStudentDAO;
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    @Transactional
    public Student findById(int rollNum) {
        return studentDAO.findById(rollNum);
    }

    @Override
    @Transactional
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Override
    @Transactional
    public void deleteById(int roll_number) {
        studentDAO.deleteById(roll_number);
    }
}
