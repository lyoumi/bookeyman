package com.bookeyman.store.resource;

import static org.springframework.http.HttpStatus.OK;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("store")
public class BookStoreResource {

    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;
    private final ConverterService converter;

    @ResponseStatus(OK)
    @MessageMapping("book")
    public Flux<BookProductPayload> getAllBookProducts() {
        return bookService.getAllBookProducts()
                .map(converter::convert);
    }

    @ResponseStatus(OK)
    @MessageMapping("book/{id}")
    public Mono<BookPayload> getBookById(@DestinationVariable String id) {
        return bookService.getBookById(id)
                .map(converter::convert);
    }

    @ResponseStatus(OK)
    @MessageMapping(value = "genre")
    public Flux<GenrePayload> getGenres() {
        return genreService.getAllGenres()
                .map(converter::convert);
    }

    @ResponseStatus(OK)
    @MessageMapping("genre/{id}")
    public Mono<GenrePayload> getGenreById(@DestinationVariable String id) {
        return genreService.getGenreById(id).map(converter::convert);
    }

    @ResponseStatus(OK)
    @MessageMapping(value = "author")
    public Flux<AuthorPayload> getAllAuthors() {
        return authorService.getAllAuthors()
                .map(converter::convert);
    }

    @ResponseStatus(OK)
    @MessageMapping(value = "author/{id}")
    public Mono<AuthorPayload> getAuthorById(@PathVariable String id) {
        return authorService.getAuthorById(id).map(converter::convert);
    }
}
