package com.huy.homework2.model;

public class Student {
    private String name_student;
    private String email_student;
    private int age_student;

    public Student(String name_student, String email_student, int age_student) {
        this.name_student = name_student;
        this.email_student = email_student;
        this.age_student = age_student;
    }

    public String getStudent_name() {
        return name_student;
    }

    public void setStudent_name(String name_student) {
        this.name_student = name_student;
    }

    public String getEmail_student() {
        return email_student;
    }

    public void setEmail_student(String email_student) {
        this.email_student = email_student;
    }

    public int getAge_student() {
        return age_student;
    }

    public void setAge_student(int age_student) {
        this.age_student = age_student;
    }
}