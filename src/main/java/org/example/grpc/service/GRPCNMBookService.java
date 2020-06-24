package org.example.grpc.service;

import ma.glasnost.orika.MapperFacade;
import org.example.NMVnext.GRPCBook;
import org.example.NMVnext.NMAPIBookServiceGrpc;
import org.example.grpc.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GRPCNMBookService {

    private NMAPIBookServiceGrpc.NMAPIBookServiceBlockingStub client;

    private MapperFacade mapper;

    public GRPCNMBookService(NMAPIBookServiceGrpc.NMAPIBookServiceBlockingStub client, MapperFacade mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    public Book add(Book book) {

        GRPCBook.Book requestBook = GRPCBook.Book.newBuilder()
                .setId(book.getId())
                .setCost(book.getCost())
                .setPages(book.getPages())
                .setAuthor(book.getAuthor())
                .setName(book.getName())
                .build();
        GRPCBook.Book bookResponse = client.addBook(requestBook);
        return book;
    }

    public Book get(int bookId) throws Exception {

        GRPCBook.IntegerMessageType request = GRPCBook.IntegerMessageType.newBuilder().setId(bookId).build();
        GRPCBook.Book bookResponse = client.getBook(request);
        return mapper.map(bookResponse, Book.class);
    }

    public List<Book> getAllBooks() {
        GRPCBook.VoidMessageType request = GRPCBook.VoidMessageType.newBuilder().build();
        GRPCBook.BookPacket allBookResponse = client.getAllBooks(request);
        return allBookResponse
                .getItemsList()
                .stream()
                .map(b -> mapper.map(b, Book.class))
                .collect(Collectors.toList());

    }

    public void deleteBook(int bookId) {
        GRPCBook.IntegerMessageType request = GRPCBook.IntegerMessageType.newBuilder().setId(bookId).build();
        client.deleteBook(request);
    }

    public Book putBook(int bookId, Book book) {
        GRPCBook.Book requestBook = GRPCBook.Book.newBuilder()
                .setId(book.getId())
                .setCost(book.getCost())
                .setPages(book.getPages())
                .setAuthor(book.getAuthor())
                .setName(book.getName())
                .build();
        GRPCBook.PutMessageType request = GRPCBook.PutMessageType.newBuilder().setId(bookId).setBook(requestBook).build();
        GRPCBook.Book bookResponse = client.putBook(request);
        Book result = mapper.map(bookResponse, Book.class);
        return result;
    }
}
