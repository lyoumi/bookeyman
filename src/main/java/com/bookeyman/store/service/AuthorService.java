package com.bookeyman.store.service;

import com.bookeyman.store.entity.Author;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AuthorService {

    Mono<Author> createAuthor(Author author);

    Mono<Author> getAuthorById(String id);

    Flux<Author> getAllAuthors();

    Flux<Author> getAllAuthorsByName(String name);


    void deleteById(String id);
}
