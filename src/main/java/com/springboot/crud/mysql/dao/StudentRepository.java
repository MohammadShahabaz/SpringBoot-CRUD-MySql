package com.springboot.crud.mysql.dao;

import com.springboot.crud.mysql.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<Student, Integer> {
}
