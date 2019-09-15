package com.springboot.crud.mysql.dao;


import com.springboot.crud.mysql.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Primary
public class StudentDAOJPAImpl implements StudentDAO {

    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public StudentDAOJPAImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Student> findAll() {

        // create a query
        TypedQuery<Student> theQuery =
                entityManager.createQuery("from Student", Student.class);

        // execute query and get result list
        List<Student> students = theQuery.getResultList();

        // return the results
        return students;
    }

    @Override
    public Student findById(int roll_number) {
        //Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Student student =
                entityManager.find(Student.class, roll_number);

        return student;
    }

    @Override
    public void save(Student theStudent) {
       // Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        entityManager.merge(theStudent);

    }

    @Override
    public void deleteById(int roll_number) {
       // Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                entityManager.createQuery("delete from Student where roll_number=:roll_number");
        theQuery.setParameter("roll_number", roll_number);

        theQuery.executeUpdate();
    }
}
