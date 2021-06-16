package com.bookeyman.store.service.impl;

import com.bookeyman.store.entity.Book;
import com.bookeyman.store.entity.BookProduct;
import com.bookeyman.store.repository.BookProductRepository;
import com.bookeyman.store.repository.BookRepository;
import com.bookeyman.store.service.BookService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookProductRepository bookProductRepository;

    @Override
    public Mono<Book> crateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Mono<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Flux<BookProduct> getAllBookProducts() {
        return bookProductRepository.findAllByIsDisabledIsFalse();
    }
}
