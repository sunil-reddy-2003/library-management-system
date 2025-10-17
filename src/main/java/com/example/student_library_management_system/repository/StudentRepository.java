package com.example.student_library_management_system.repository;

import com.example.student_library_management_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    //customized SQL queries

    @Query(nativeQuery = true,value = "SELECT * FROM STUDENT WHERE EMAIL= :email")
    public Student getStudentByEmail(String email);

    @Query(nativeQuery = true,value = "SELECT * FROM STUDENT WHERE DEPARTMENT= :inputDept")
    public List<Student> getStudentByDept(String inputDept);
}
