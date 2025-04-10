package com.example.studentsmanage.Reporsitory;

import com.example.studentsmanage.Entities.Students;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo implements StudentRepoInterface {
    private final JdbcTemplate jdbcTemplate;

    // private Integer uid;
    //    private String name;
    //    private String Email;
    //    private Timestamp enrolledTime;
    //    private Integer age;
    //    private String gender;
    private final RowMapper<Students> studentsRowMapper = (rs, rowNum) -> new Students(
            rs.getInt("uid"),
            rs.getString("name"),
            rs.getString("Email"),
            rs.getTimestamp("enrolledTime"),
            rs.getInt("age"),
            rs.getString("gender"));
    @Autowired
    public StudentRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Boolean addStudent(Students students) {
        String sql = "INSERT INTO student (name, email, enrolledTime, age, gender) VALUES (?, ?, ?, ?, ?)";
        try {
            int result = jdbcTemplate.update(sql,
                    students.getName(),
                    students.getEmail(),
                    students.getEnrolledTime(),
                    students.getAge(),
                    students.getGender()
            );
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Students> findByName(String name) {
        String sql = "select * from students where name like '% ? %'";
        List<Students> students = jdbcTemplate.query(sql, studentsRowMapper, name);
        return students;
    }

    @Override
    @Transactional
    public List<Students> getAllStudents() {
        try{
            String sql = "select * from student";
            List<Students> studentsList =  jdbcTemplate.query(sql, studentsRowMapper);
            return studentsList;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Students getStudentById(int id) {
        String sql = "select * from student where uid = ?";
        Students students = jdbcTemplate.queryForObject(sql, studentsRowMapper, id);
        return students;
    }

    @Override
    public Boolean deleteStudentById(int id) {
        String sql = "DELETE FROM student WHERE uid = ?";
        try {
            int result = jdbcTemplate.update(sql, id);
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean updateStudent(Students students) {
        String sql = "UPDATE student SET name = ?, email = ?, enrolledTime = ?, age = ?, gender = ? WHERE uid = ?";
        try {
            int result = jdbcTemplate.update(sql,
                    students.getName(),
                    students.getEmail(),
                    students.getEnrolledTime(),
                    students.getAge(),
                    students.getGender(),
                    students.getUid()
            );
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
