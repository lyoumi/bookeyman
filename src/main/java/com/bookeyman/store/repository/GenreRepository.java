package com.bookeyman.store.repository;

import com.bookeyman.store.entity.Genre;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, String> {

    List<Genre> getAllByName(String name);

}
