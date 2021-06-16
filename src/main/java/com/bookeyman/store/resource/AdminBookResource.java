package com.bookeyman.store.resource;

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
import reactor.core.publisher.Mono;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
@MessageMapping("store/admin")
public class AdminBookResource {

    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;
    private final ConverterService converter;
    private final AuditRSocketClient auditRSocketClient;

    @MessageMapping("book")
    public Mono<BookPayload> createBook(BookPayload bookPayload) {
        Book book = converter.convert(bookPayload);
        return bookService.crateBook(book).map(converter::convert);
    }

    @MessageMapping("book/{id}")
    public void deleteBookById(@DestinationVariable String id) {
        bookService.deleteBookById(id);
    }

    @MessageMapping("genre")
    public Mono<GenrePayload> createGenre(GenrePayload genrePayload) {
        Genre genre = converter.convert(genrePayload);
        return genreService.createGenre(genre).map(converter::convert);
    }

    @MessageMapping("genre/{id}")
    public void deleteGenreById(@DestinationVariable String id) {
        genreService.deleteGenreById(id);
    }

    @MessageMapping("author")
    public Mono<AuthorPayload> createAuthor(AuthorPayload authorPayload) {
        Author author = converter.convert(authorPayload);
        return authorService.createAuthor(author).map(converter::convert);
    }

    @MessageMapping("author/{id}")
    public void deleteAuthorById(@DestinationVariable String id) {
        authorService.deleteById(id);
    }

    @MessageMapping("audit")
    public void testAudit() {
        auditRSocketClient.sendAuditReport(new BookProduct("1", 2.0, 1, false, new Book()), ActionType.PURCHASE);
    }
}
