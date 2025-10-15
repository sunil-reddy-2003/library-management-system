package com.example.student_library_management_system.model;

import com.example.student_library_management_system.enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table
public class Card {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @Column(nullable = false)
    private String expiryDate;

    @Column(nullable = false)
    @CreationTimestamp
    private Date createDate;

    @Column(nullable = false)
    @UpdateTimestamp
    private Date updateDate;

    @JoinColumn //student pk will be joined to card table
    @OneToOne
    private Student student;

    @OneToMany(mappedBy = "card")
    private List<Book> booksOfCard;

    @OneToMany(mappedBy = "card")
    private List<Transaction> transactionsList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Book> getBooksOfCard() {
        return booksOfCard;
    }

    public void setBooksOfCard(List<Book> booksOfCard) {
        this.booksOfCard = booksOfCard;
    }

    public List<Transaction> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transaction> transactionsList) {
        this.transactionsList = transactionsList;
    }
}
