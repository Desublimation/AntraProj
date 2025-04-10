package com.example.studentsmanage.Controller;

import com.example.studentsmanage.Entities.Students;
import com.example.studentsmanage.Service.StudentAccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/index/")
public class StudentAccController {

    private StudentAccService studentAccService;

    @Autowired
    public StudentAccController(StudentAccService studentAccService) {
        this.studentAccService = studentAccService;
    }


    @GetMapping("/allStu")
    public List<Students> getAllStudents(){
        Optional<List<Students>> students = studentAccService.getAllStudents();
        if (students.isPresent()) {
            List<Students> studentsList = students.get();
            return studentsList;
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<Boolean> addNewStudent(@RequestBody Students students){
        students.setEnrolledTime(new Timestamp(System.currentTimeMillis()));
        Optional<Boolean> addresult = studentAccService.addStudent(students);
        if (addresult.isPresent()) {
            return ResponseEntity.ok( addresult.get());
        }
        return ResponseEntity.ok(false);

    }

    @PutMapping("/updateStu")
    public ResponseEntity<Boolean> updateStudent(@RequestBody Students students){
        students.setEnrolledTime(new Timestamp(System.currentTimeMillis()));
        Optional<Boolean> updateResult = studentAccService.updateStudent(students);
        if (updateResult.isPresent()) {
            return ResponseEntity.ok(updateResult.get());
        }
        return ResponseEntity.ok(false);
    }

    @DeleteMapping("/deleteStu")
    public ResponseEntity<Boolean> deleteStudent(@RequestBody int uid){

        Optional<Boolean> deleteResult = studentAccService.deleteStudentById(uid);
        if (deleteResult.isPresent()) {
            return ResponseEntity.ok(deleteResult.get());
        }
        return ResponseEntity.ok(false);
    }
}
