package com.bookeyman.store.repository;

import com.bookeyman.store.entity.Book;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BookRepository extends ReactiveCrudRepository<Book, String> {

}
