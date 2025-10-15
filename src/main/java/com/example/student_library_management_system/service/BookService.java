package com.example.student_library_management_system.service;

import com.example.student_library_management_system.converters.BookConverter;
import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.model.Card;
import com.example.student_library_management_system.repository.AuthorRepository;
import com.example.student_library_management_system.repository.BookRepository;
import com.example.student_library_management_system.repository.CardRepository;
import com.example.student_library_management_system.requestdto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //if foreign keys are present, we should fetch them from their repository

    @Autowired
    private AuthorRepository authorRepository;


    @Autowired
    private CardRepository cardRepository;

    public String saveBook(BookRequestDto bookRequestDto){
        Book book= BookConverter.convertBookRequestInToBookModel(bookRequestDto);


        //using authorID fetch the complete object of author from the authorRepository
        Author author=authorRepository.findById(bookRequestDto.getAuthorId()).get();
        if(author!=null){
            book.setAuthor(author);
        }else {
            book.setAuthor(null);
        }

        //using cardID fetch the complete object of card from the cardRepository
        Card card=cardRepository.findById(bookRequestDto.getCardId()).get();
        if(card!=null){
            book.setCard(card);
        }else {
            book.setCard(null);
        }


        bookRepository.save(book);
        return "book saved successfully";
    }


}
