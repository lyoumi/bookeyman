package com.bookeyman.store.listeners;

import com.bookeyman.store.data.AuthorPayload;
import com.bookeyman.store.data.BookPayload;
import com.bookeyman.store.data.BookProductPayload;
import com.bookeyman.store.data.GenrePayload;
import com.bookeyman.store.service.AuthorService;
import com.bookeyman.store.service.BookService;
import com.bookeyman.store.service.GenreService;
import com.bookeyman.store.service.mappers.ConverterService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
@MessageMapping("store")
public class BookStoreListener {

    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;
    private final ConverterService converter;

    @MessageMapping("book")
    public Flux<BookProductPayload> getAllBookProducts() {
        return bookService.getAllBookProducts()
                .map(converter::convert);
    }

    @MessageMapping("book/{id}")
    public Mono<BookPayload> getBookById(@DestinationVariable String id) {
        return bookService.getBookById(id)
                .map(converter::convert);
    }

    @MessageMapping(value = "genre")
    public Flux<GenrePayload> getGenres() {
        return genreService.getAllGenres()
                .map(converter::convert);
    }

    @MessageMapping("genre/{id}")
    public Mono<GenrePayload> getGenreById(@DestinationVariable String id) {
        return genreService.getGenreById(id).map(converter::convert);
    }

    @MessageMapping("author")
    public Flux<AuthorPayload> getAllAuthors() {
        return authorService.getAllAuthors()
                .map(converter::convert);
    }

    @MessageMapping("author/{id}")
    public Mono<AuthorPayload> getAuthorById(@DestinationVariable String id) {
        return authorService.getAuthorById(id).map(converter::convert);
    }
}
