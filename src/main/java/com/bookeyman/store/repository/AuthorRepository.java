package com.bookeyman.store.repository;

import com.bookeyman.store.entity.Author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, String> {

    List<Author> findAllByName(String name);
}
