package com.bookeyman.store.repository;

import com.bookeyman.store.entity.Author;
import reactor.core.publisher.Flux;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.List;

public interface AuthorRepository extends ReactiveCrudRepository<Author, String> {

    Flux<Author> findAllByName(String name);
}
