package com.bookeyman.store.service.impl;

import com.bookeyman.store.entity.Genre;
import com.bookeyman.store.repository.GenreRepository;
import com.bookeyman.store.service.GenreService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public Genre createGenre(Genre genre) {
        return genreRepository.saveAndFlush(genre);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> getAllGenresByName(String name) {
        return genreRepository.getAllByName(name);
    }

    @Override
    public Genre getGenreById(String id) {
        return genreRepository.getOne(id);
    }

    @Override
    public void deleteGenreById(String id) {
        genreRepository.deleteById(id);
    }
}
