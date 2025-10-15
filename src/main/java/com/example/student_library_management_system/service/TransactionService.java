package com.example.student_library_management_system.service;

import com.example.student_library_management_system.converters.TransactionConverter;
import com.example.student_library_management_system.enums.TransactionType;
import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.model.Card;
import com.example.student_library_management_system.model.Transaction;
import com.example.student_library_management_system.repository.BookRepository;
import com.example.student_library_management_system.repository.CardRepository;
import com.example.student_library_management_system.repository.TransactionRepository;
import com.example.student_library_management_system.requestdto.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private BookRepository bookRepository;

    public String saveTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction= TransactionConverter.convertTransactionRequestInToTransactionModel(transactionRequestDto);

        Card card=cardRepository.findById(transactionRequestDto.getCardId()).get();
        if(card!=null){
            transaction.setCard(card);
        }else {
            transaction.setCard(null);
        }

        Book book=bookRepository.findById(transactionRequestDto.getBookId()).get();
        if(book!=null){
            transaction.setBook(book);
        }else {
            transaction.setBook(null);
        }
        transaction.setDueDate(transactionRequestDto.getDueDate());

        transactionRepository.save(transaction);
        return "transaction saved";
    }

}
