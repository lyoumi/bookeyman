package com.bookeyman.store.service;

import com.bookeyman.store.entity.Book;
import com.bookeyman.store.entity.BookProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BookService {

    Mono<Book> crateBook(Book book);

    Mono<Book> getBookById(String id);

    Flux<Book> getAllBooks();

    void deleteBookById(String id);

    Flux<BookProduct> getAllBookProducts();

}
