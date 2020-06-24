package org.example.grpc.service;

import org.example.grpc.model.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookService {

    private Map<Integer, Book> map = new HashMap<>();

    public Book add(Book book) {
        map.put(book.getId(), book);
        return book;
    }

    public Book get(int bookId) throws Exception {
        Book book = map.get(bookId);

        if(book == null){
            throw new Exception("Not found");
        }
        return book;
    }

    public List<Book> getAllBooks() {
       return map.values().stream().collect(Collectors.toList());

    }

    public void deleteBook(int bookId) {
        map.remove(bookId);
    }

    public Book putBook(int bookId, Book book) throws Exception {

        if(map.containsKey(bookId)){
            book.setId(bookId);
            map.put(bookId, book);
            return book;
        }
        throw new Exception("Not found");
    }
}
