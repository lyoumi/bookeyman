package com.bookeyman.store.service.impl;

import com.bookeyman.store.entity.Book;
import com.bookeyman.store.repository.BookRepository;
import com.bookeyman.store.service.BookService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book crateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.getOne(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }
}
