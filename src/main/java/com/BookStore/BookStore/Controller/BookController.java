package com.BookStore.BookStore.Controller;


import com.BookStore.BookStore.Models.Book;
import com.BookStore.BookStore.Models.MyBookList;
import com.BookStore.BookStore.Repository.BookRepo;
import com.BookStore.BookStore.Service.BookService;
import com.BookStore.BookStore.Service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    MyBookListService myBookListService;
    @Autowired
    BookService bookService;
    @GetMapping("")
    public String hee(){
        return "home";
    }

    @GetMapping("/book_register")
    public String addBook(){
        return "bookRegister";
    }
    @GetMapping("/available_books")
    public ModelAndView getAllBook(){
        List<Book> list=bookService.getAllbooks();
//        ModelAndView m=new ModelAndView();
//        m.setViewName("bookList");
//        m.addObject("book",list);
        return new ModelAndView("bookList","book",list);


    }
    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book b){
        bookRepo.save(b);
        return "redirect:/available_books";
    }

    @GetMapping("/myList/{id}")
    public  String getMyList(@PathVariable("id") int id){
//        System.out.println(id);
        Book b=bookService.getBookById(id);

        MyBookList bb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookListService.saveMyListBook(bb);
        return "redirect:/my_books";
    }
    @GetMapping("/editBook/{id}")
    public String editTheBook(@PathVariable("id") int id, Model model){
        Book b=bookService.getBookById(id);
      //  System.out.println(b.getAuthor());
        model.addAttribute("book",b);
        return "BookEdit";
    }
    @PostMapping("/saveEditedBook")
    public String saveEditedBook(@ModelAttribute Book b){

       int id=b.getId();
        Book b2=bookService.getBookById(id);
        b2.setName(b.getName());
        b2.setPrice(b.getPrice());
        b2.setAuthor(b.getAuthor());
        bookRepo.save(b2);
        return "redirect:/available_books";

    }
    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
        bookRepo.deleteById(id);
        return "redirect:/available_books";
    }

}
