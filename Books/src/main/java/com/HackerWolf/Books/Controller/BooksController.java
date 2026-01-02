package com.HackerWolf.Books.Controller;

import com.HackerWolf.Books.entity.books;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksController {

    private final List<books> Books= new ArrayList<>();

    public BooksController(){
        initializeBooks();
    }

    private void initializeBooks(){
        Books.addAll(List.of(
                new books("Title one", "Author one", "Science"),
                new books("Title two", "Author two", "Social"),
                new books("Title Three", "Author Three", "Computer"),
                new books("Title Four", "Author Four", "Maths"),
                new books("Title Five", "Author Five", "English"),
                new books("Title Six", "Author Six", "Tamil")
        ));
    }

    @GetMapping("/api/books")
    public List<books> getBooks(){
        return Books;
    }

//    @GetMapping("/api/books/{title}")
//    public books book(@PathVariable String title){
//        for(books books:Books){
//            if(books.getTitle().equalsIgnoreCase(title)){
//                return books;
//            }
//        }
//        return null;
//    }

    @GetMapping("api/books/{title}")
    public books getBookByTitle(@PathVariable String title){
        return Books.stream()
                .filter(books -> books.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }
}
