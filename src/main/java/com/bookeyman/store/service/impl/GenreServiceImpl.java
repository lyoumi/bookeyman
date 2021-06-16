package com.bookeyman.store.service.impl;

import com.bookeyman.store.entity.Genre;
import com.bookeyman.store.repository.GenreRepository;
import com.bookeyman.store.service.GenreService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public Mono<Genre> createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Flux<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Flux<Genre> getAllGenresByName(String name) {
        return genreRepository.getAllByName(name);
    }

    @Override
    public Mono<Genre> getGenreById(String id) {
        return genreRepository.findById(id);
    }

    @Override
    public void deleteGenreById(String id) {
        genreRepository.deleteById(id);
    }
}
