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

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("store")
public class BookStoreResource {

    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;
    private final ConverterService converterService;

    @ResponseStatus(OK)
    @GetMapping(value = "book")
    public List<BookProductPayload> getAllBookProducts() {
        return bookService.getAllBookProducts().stream()
                .map(converterService::convert)
                .collect(Collectors.toList());
    }

    @ResponseStatus(OK)
    @GetMapping(value = "book/{id}")
    public BookPayload getBookById(@PathVariable String id) {
        return converterService.convert(bookService.getBookById(id));
    }

    @ResponseStatus(OK)
    @GetMapping(value = "genre")
    public List<GenrePayload> getGenres() {
        return genreService.getAllGenres().stream()
                .map(converterService::convert)
                .collect(Collectors.toList());
    }

    @ResponseStatus(OK)
    @GetMapping(value = "genre/{id}")
    public GenrePayload getGenreById(@PathVariable String id) {
        return converterService.convert(genreService.getGenreById(id));
    }

    @ResponseStatus(OK)
    @GetMapping(value = "author")
    public List<AuthorPayload> getAllAuthors() {
        return authorService.getAllAuthors().stream()
                .map(converterService::convert)
                .collect(Collectors.toList());
    }

    @ResponseStatus(OK)
    @GetMapping(value = "author/{id}")
    public AuthorPayload getAuthorById(@PathVariable String id) {
        return converterService.convert(authorService.getAuthorById(id));
    }
}
