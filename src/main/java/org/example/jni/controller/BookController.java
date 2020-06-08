package org.example.jni.controller;

import lombok.Data;
import org.example.jni.model.Book;
import org.example.jni.service.BookService;
import org.example.jni.service.GRPCNMBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private GRPCNMBookService bookService; // inject gRPC_JavaClient

    @PostMapping()
    public Book addBook(@RequestBody Book book) {
        return bookService.add(book);
    }


    @GetMapping("{bookId}")
    public Book getBook(@PathVariable int bookId) throws Exception {
        return bookService.get(bookId);
    }

    @GetMapping()
    public List<Book> GetAllBooks() throws Exception {
        return bookService.getAllBooks();
    }

    @DeleteMapping("{bookId}")
    public void deleteBook(@PathVariable int bookId) {
        bookService.deleteBook(bookId);
    }

    @PutMapping("{bookId}")
    public Book putBook(@PathVariable int bookId, @RequestBody Book book) throws Exception {
        return bookService.putBook(bookId, book);
    }
}
