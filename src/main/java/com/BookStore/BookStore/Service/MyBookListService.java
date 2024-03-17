package com.BookStore.BookStore.Service;

import com.BookStore.BookStore.Models.MyBookList;
import com.BookStore.BookStore.Repository.MyBookListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {
    @Autowired
    MyBookListRepo myBookListRepo;
    public void saveMyListBook(MyBookList book){
        myBookListRepo.save(book);
    }
    public List<MyBookList> getAllMyBooks(){
        return myBookListRepo.findAll();
    }
}
