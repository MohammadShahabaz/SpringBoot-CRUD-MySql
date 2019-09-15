package com.springboot.crud.mysql.rest;


import com.springboot.crud.mysql.entity.Student;
import com.springboot.crud.mysql.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/s")
public class StudentRestController {

    private static final Logger logger = LogManager.getLogger(StudentRestController.class);


    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public List<Student> findAll() {
        logger.debug("Hello from Log4j 2 debug : "+studentService.findAll());
        logger.info("Hello from Log4j 2 info : "+studentService.findAll());
        logger.error("Hello from Log4j 2 error : "+studentService.findAll());
        return studentService.findAll();
    }
    @GetMapping("/students/{roll_number}")
    public Student getEmployee(@PathVariable int roll_number) {

        Student theStudent = studentService.findById(roll_number);

        if ( theStudent == null) {
            throw new RuntimeException("Student id not found - " + roll_number);
        }

        return theStudent;
    }


    @PostMapping("/student")
    public Student addStudent(@RequestBody Student theStudent) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        //theStudent.setRoll_number(0);

        studentService.save(theStudent);

        return theStudent;
    }


    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student theStudent) {

        studentService.save(theStudent);

        return theStudent;
    }


    @DeleteMapping("/student/delete/{roll_number}")
    public String deleteEmployee(@PathVariable int roll_number) {

        Student tempStudent = studentService.findById(roll_number);

        // throw exception if null

        if (tempStudent == null) {
            throw new RuntimeException("Student id not found - " + roll_number);
        }

        studentService.deleteById(roll_number);

        return "Deleted student id - " + roll_number;
    }

}
