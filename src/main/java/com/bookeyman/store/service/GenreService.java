package com.bookeyman.store.service;

import com.bookeyman.store.entity.Genre;

import java.util.List;

public interface GenreService {

    Genre createGenre(Genre genre);

    List<Genre> getAllGenres();

    List<Genre> getAllGenresByName(String name);

    Genre getGenreById(String id);

    void deleteGenreById(String id);
}
