package com.example.studentsmanage.Service;

import com.example.studentsmanage.Entities.Students;
import com.example.studentsmanage.Reporsitory.StudentRepo;
import com.example.studentsmanage.Reporsitory.StudentRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAccService {

    private StudentRepoInterface studentRepo;
    @Autowired
    public StudentAccService(StudentRepoInterface studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Optional<List<Students>> getAllStudents() {
        try {
            List<Students> allStu = studentRepo.getAllStudents();
            return Optional.of(allStu);
        }catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<Students> getStudentById(int id) {
        Students stu = studentRepo.getStudentById(id);
        return Optional.of(stu);

    }

    public Optional<Boolean> deleteStudentById(int id) {
        boolean stu = studentRepo.deleteStudentById(id);
        return Optional.of(stu);
    }

    public Optional<Boolean> updateStudent(Students stu) {

        boolean stu1 = studentRepo.updateStudent(stu);
        return Optional.of(stu1);
    }

    public Optional<Boolean> addStudent(Students stu) {
        boolean stu1 = studentRepo.addStudent(stu);
        return Optional.of(stu1);
    }
}
