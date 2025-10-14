package com.example.student_library_management_system.model;


import com.example.student_library_management_system.enums.Category;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="book_title",nullable = false)
    private String title;

    @Column(name="publisher_name",nullable = false)
    private String publisherName;

    @Column(name="published_date",nullable = false)
    private String publishedDate;

    @Column(nullable = false)
    private int pages;

    @Column(nullable = false)
    private boolean availability;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private String rack_no;


    @JoinColumn
    @ManyToOne // many books written by one author
    private Author author;

    @JoinColumn
    @ManyToOne
    private Card card;


    @OneToMany(mappedBy = "book")
    private List<Transaction> transactionList;

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getRack_no() {
        return rack_no;
    }

    public void setRack_no(String rack_no) {
        this.rack_no = rack_no;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
