package com.springboot.crud.mysql.dao;


import com.springboot.crud.mysql.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOHibernateImpl implements StudentDAO {

    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public StudentDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Student> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Student> theQuery =
                currentSession.createQuery("from Student", Student.class);

        // execute query and get result list
        List<Student> students = theQuery.getResultList();

        // return the results
        return students;
    }

    @Override
    public Student findById(int roll_number) {
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Student student =
                currentSession.get(Student.class, roll_number);

        return student;
    }

    @Override
    public void save(Student theStudent) {
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        currentSession.saveOrUpdate(theStudent);

    }

    @Override
    public void deleteById(int roll_number) {
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Student where roll_number=:roll_number");
        theQuery.setParameter("roll_number", roll_number);

        theQuery.executeUpdate();
    }
}
