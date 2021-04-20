package com.bookeyman.store.service;

import com.bookeyman.store.entity.Book;
import com.bookeyman.store.entity.Genre;

import java.util.List;

public interface BookService {

    Book crateBook(Book book);

    Book getBookById(String id);

    List<Book> getAllBooks();

    void deleteBookById(String id);

}
