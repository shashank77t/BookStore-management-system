package com.BookStore.BookStore.Repository;

import com.BookStore.BookStore.Models.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookListRepo extends JpaRepository<MyBookList,Integer> {

}
