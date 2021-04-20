package com.bookeyman.store.service;

import com.bookeyman.store.entity.Author;

import java.util.List;

public interface AuthorService {

    Author createAuthor(Author author);

    Author getAuthorById(String id);

    List<Author> getAllAuthors();

    List<Author> getAllAuthorsByName(String name);


    void deleteById(String id);
}
