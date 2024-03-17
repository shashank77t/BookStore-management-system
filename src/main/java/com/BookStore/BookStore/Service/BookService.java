package com.BookStore.BookStore.Service;

import com.BookStore.BookStore.Models.Book;
import com.BookStore.BookStore.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;
    public List<Book> getAllbooks(){
        List<Book>list;
        list=bookRepo.findAll();
       return list;
    }
    public Book getBookById(int id){
        return bookRepo.findById(id).orElse(null);
    }
}
