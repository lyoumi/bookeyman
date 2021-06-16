package com.bookeyman.store.repository;

import com.bookeyman.store.entity.Genre;
import reactor.core.publisher.Flux;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.List;

public interface GenreRepository extends ReactiveCrudRepository<Genre, String> {

    Flux<Genre> getAllByName(String name);

}
