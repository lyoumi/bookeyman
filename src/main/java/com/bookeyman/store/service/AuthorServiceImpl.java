package com.bookeyman.store.service;

import com.bookeyman.store.entity.Author;
import com.bookeyman.store.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Mono<Author> createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Mono<Author> getAuthorById(String id) {
        return authorRepository.findById(id);
    }

    @Override
    public Flux<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Flux<Author> getAllAuthorsByName(String name) {
        return authorRepository.findAllByName(name);
    }

    @Override
    public void deleteById(String id) {
        authorRepository.deleteById(id);
    }
}
