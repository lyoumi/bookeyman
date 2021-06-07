package com.bookeyman.store.resource;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import com.bookeyman.store.clients.AuditRSocketClient;
import com.bookeyman.store.data.AuditReportPayload.ActionType;
import com.bookeyman.store.data.AuthorPayload;
import com.bookeyman.store.data.BookPayload;
import com.bookeyman.store.data.GenrePayload;
import com.bookeyman.store.entity.Author;
import com.bookeyman.store.entity.Book;
import com.bookeyman.store.entity.BookProduct;
import com.bookeyman.store.entity.Genre;
import com.bookeyman.store.service.AuthorService;
import com.bookeyman.store.service.BookService;
import com.bookeyman.store.service.GenreService;
import com.bookeyman.store.service.mappers.ConverterService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("store/admin")
public class AdminBookResource {

    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;
    private final ConverterService converterService;
    private final AuditRSocketClient auditRSocketClient;

    @ResponseStatus(CREATED)
    @PostMapping(value = "book")
    public BookPayload createBook(@RequestBody BookPayload bookPayload) {
        Book book = converterService.convert(bookPayload);
        return converterService.convert(bookService.crateBook(book));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(value = "book/{id}")
    public void deleteBookById(@PathVariable String id) {
        bookService.deleteBookById(id);
    }

    @ResponseStatus(CREATED)
    @PostMapping(value = "genre")
    public GenrePayload createGenre(@RequestBody GenrePayload genrePayload) {
        Genre genre = converterService.convert(genrePayload);
        return converterService.convert(genreService.createGenre(genre));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(value = "genre/{id}")
    public void deleteGenreById(@PathVariable String id) {
        genreService.deleteGenreById(id);
    }

    @ResponseStatus(CREATED)
    @PostMapping(value = "author")
    public AuthorPayload createAuthor(@RequestBody AuthorPayload authorPayload) {
        Author author = converterService.convert(authorPayload);
        return converterService.convert(authorService.createAuthor(author));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(value = "author/{id}")
    public void deleteAuthorById(@PathVariable String id) {
        authorService.deleteById(id);
    }

    @ResponseStatus(NO_CONTENT)
    @PostMapping(value = "audit")
    public void testAudit() {
        auditRSocketClient.sendAuditReport(new BookProduct("1", 2.0, 1, false, new Book()), ActionType.PURCHASE);
    }
}
