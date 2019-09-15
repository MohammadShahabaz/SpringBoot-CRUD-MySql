package com.springboot.crud.mysql.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class Student {

    // roll_number
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roll_number;

    @Column(name = "name")
    private String name;
    //name

    //subject
    @Column(name = "subject")
    private String subject;

    //marks
    @Column(name = "marks")
    private int marks;

    public Student() {

    }
    public Student(int roll_number, String name, String subject, int marks) {
        this.roll_number = roll_number;
        this.name = name;
        this.subject = subject;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll_number=" + roll_number +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", marks=" + marks +
                '}';
    }
}
