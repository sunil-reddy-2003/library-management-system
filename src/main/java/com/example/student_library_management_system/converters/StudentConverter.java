package com.example.student_library_management_system.converters;

import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.requestdto.StudentRequestDto;

public class StudentConverter {
    //converter-converts the request dto into model classes. so, that the model class gets saved in the database as a table data.

    public static Student convertStudentRequestInToStudentModel(StudentRequestDto studentRequestDto){

        Student student= new Student();

        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        student.setMobile(studentRequestDto.getMobile());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setSemester(studentRequestDto.getSemester());
        student.setGender(studentRequestDto.getGender());
        student.setAddress(studentRequestDto.getAddress());
        student.setDob(studentRequestDto.getDob());

        return student;
    }
}
