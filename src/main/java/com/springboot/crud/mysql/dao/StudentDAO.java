package com.springboot.crud.mysql.dao;

import com.springboot.crud.mysql.entity.Student;

import java.util.List;

public interface StudentDAO {

    public List<Student> findAll();

    public Student findById(int roll_number);

    public void save(Student theStudent);

    public void deleteById(int roll_number);
}
