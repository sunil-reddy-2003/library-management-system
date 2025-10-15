package com.example.student_library_management_system.service;

import com.example.student_library_management_system.converters.StudentConverter;
import com.example.student_library_management_system.enums.CardStatus;
import com.example.student_library_management_system.model.Card;
import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.repository.StudentRepository;
import com.example.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(StudentRequestDto studentRequestDto){
        Student student=StudentConverter.convertStudentRequestInToStudentModel(studentRequestDto);

        //the card will be created as the student is created

        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setExpiryDate(LocalDate.now().plusYears(4).toString());
        card.setStudent(student);
        student.setCard(card);
        studentRepository.save(student);
        return "Student saved successfully";
    }
}
