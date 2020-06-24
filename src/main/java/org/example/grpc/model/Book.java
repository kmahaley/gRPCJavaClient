package org.example.grpc.model;

import lombok.Data;

@Data
public class Book {

    private int id;

    private String name;

    private String author;

    private int pages;

    private float cost;

}
