package com.example.studentsmanage.Reporsitory;

import com.example.studentsmanage.Entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepoInterface{// extends JpaRepository<Students, Integer> {

    public Boolean addStudent(Students students);
    public List<Students> findByName(String name);
    public List<Students> getAllStudents();
    public Students getStudentById(int id);
    public Boolean deleteStudentById(int id);
    public Boolean updateStudent(Students students);

}
