package com.bookeyman.store.service;

import com.bookeyman.store.entity.Genre;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface GenreService {

    Mono<Genre> createGenre(Genre genre);

    Flux<Genre> getAllGenres();

    Flux<Genre> getAllGenresByName(String name);

    Mono<Genre> getGenreById(String id);

    void deleteGenreById(String id);
}
