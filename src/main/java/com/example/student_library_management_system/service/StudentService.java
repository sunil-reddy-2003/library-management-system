package com.example.student_library_management_system.service;

import com.example.student_library_management_system.converters.StudentConverter;
import com.example.student_library_management_system.enums.CardStatus;
import com.example.student_library_management_system.model.Card;
import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.repository.StudentRepository;
import com.example.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
    
    public Student findStudentById(int id){
        if(studentRepository.findById(id).isPresent()){
            return studentRepository.findById(id).get();
        }else {
            throw  new RuntimeException("student not found");
        }
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public String updateStudent(int id,StudentRequestDto newStudentRequestDto){
        Student existingStudent=findStudentById(id);
        if(existingStudent!=null){
            existingStudent.setEmail(newStudentRequestDto.getEmail());
            existingStudent.setAddress(newStudentRequestDto.getAddress());
            studentRepository.save(existingStudent);
            return "student details updated";
        }else {
            return "student not found in database";
        }
    }

    public String countStudents(){
        return "total no. of students: "+studentRepository.count();
    }

    public String deleteStudent(int id) {
        Student student=findStudentById(id);
        if(student!=null){
            studentRepository.deleteById(id);
            return "student deleted successfully";
        }else {
            return "student not found";
        }
    }

                                   //just pagination

//    public List<Student> getAllStudentsUsingPage(int pageNo, int pageSize){
//        return studentRepository.findAll(PageRequest.of(pageNo,pageSize)).getContent();
////        return studentRepository.findAll(PageRequest.of(0,3)).getContent(); //parameters can be constant too
//
//    }

                                    //pagination using sorting
    public List<Student> getAllStudentsUsingPage(int pageNo, int pageSize){
        return studentRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by("name").ascending())).getContent();

    }


    public Student findStudentByEmail(String email){
        return studentRepository.getStudentByEmail(email);
    }
}
