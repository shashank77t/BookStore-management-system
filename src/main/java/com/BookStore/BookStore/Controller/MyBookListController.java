package com.BookStore.BookStore.Controller;

import com.BookStore.BookStore.Models.MyBookList;
import com.BookStore.BookStore.Repository.MyBookListRepo;
import com.BookStore.BookStore.Service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyBookListController {
    @Autowired
    MyBookListService myBookListService;
    @Autowired
     MyBookListRepo myBookListRepo;
     @GetMapping("/my_books")
     public ModelAndView getAllMyBooks(){
         List<MyBookList> lis=myBookListService.getAllMyBooks();
         return new ModelAndView("myBooks","bbb",lis);
     }
     @GetMapping("/deleteMyBook/{id}")
     public String deleteMyB(@PathVariable("id") int id){
         myBookListRepo.deleteById(id);
         return "redirect:/my_books";
     }
}
