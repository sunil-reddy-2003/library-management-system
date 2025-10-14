package com.example.student_library_management_system.converters;

import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.requestdto.BookRequestDto;


public class BookConverter {

    public static Book convertBookRequestInToBookModel(BookRequestDto bookRequestDto){
        Book book=new Book();

        book.setTitle(bookRequestDto.getTitle());
        book.setPublisherName(bookRequestDto.getPublisherName());
        book.setPublishedDate(bookRequestDto.getPublishedDate());
        book.setPages(bookRequestDto.getPages());
        book.setAvailability(bookRequestDto.isAvailability());
        book.setCategory(bookRequestDto.getCategory());
        book.setRack_no(bookRequestDto.getRack_no());

        return book;
    }

}
