package com.bookeyman.store.service;

import com.bookeyman.store.entity.Author;
import com.bookeyman.store.repository.AuthorRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(String id) {
        return authorRepository.getOne(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> getAllAuthorsByName(String name) {
        return authorRepository.findAllByName(name);
    }

    @Override
    public void deleteById(String id) {
        authorRepository.deleteById(id);
    }
}
