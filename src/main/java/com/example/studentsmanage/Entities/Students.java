package com.example.studentsmanage.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
@Entity
public class Students {

    public Students() {

    }

    @Id
    private Integer uid;
    private String name;
    private String Email;
    private Timestamp enrolledTime;
    private Integer age;
    private String gender;

    public Students(int uid, String name, String Email, Timestamp enrolledTime, Integer age, String gender) {
        this.uid = uid;
        this.name = name;
        this.Email = Email;
        this.enrolledTime = enrolledTime;
        this.age = age;
        this.gender = gender;

    }

    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }

    public Timestamp getEnrolledTime() {
        return enrolledTime;
    }

    public void setEnrolledTime(Timestamp enrolledTime) {
        this.enrolledTime = enrolledTime;
    }

    public Integer getAge() {

        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }





}
