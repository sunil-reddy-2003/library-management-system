package com.example.student_library_management_system.controller;

import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.requestdto.StudentRequestDto;
import com.example.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller+@ResponseBody=@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        return studentService.addStudent(studentRequestDto);
    }

    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable int id){
        try {
            return studentService.findStudentById(id);
        }
        catch (Exception e){
            System.out.println("exception occurred: "+e.getMessage());
            throw new RuntimeException("Student not found");
        }


        //response dto is used to send the required response only.
        //to return a particular attribute we can create response dto's and return it.
//        return studentResponseDto.setName(studentService.findStudentById(id).getName());
    }

    @GetMapping("/findAll")
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable int id,@RequestBody StudentRequestDto studentRequestDto){
        return studentService.updateStudent(id,studentRequestDto);
    }

    @GetMapping("/count")
    public String countAllStudents(){
        return studentService.countStudents();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/page")
    public List<Student> getAllStudentsUsingPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        return studentService.getAllStudentsUsingPage(pageNo,pageSize);
    }

    @GetMapping("/findByEmail")
    public Student findStudentByEmail(@RequestParam String email){
        return studentService.findStudentByEmail(email);
    }

}
