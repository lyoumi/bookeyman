package com.bookeyman.store.service.mappers;

import com.bookeyman.store.data.AuthorPayload;
import com.bookeyman.store.data.BookPayload;
import com.bookeyman.store.data.GenrePayload;
import com.bookeyman.store.entity.Author;
import com.bookeyman.store.entity.Book;
import com.bookeyman.store.entity.Genre;

public interface ConverterService {

    <T> T convert(Object source, Class<T> targetClass);

    default BookPayload convert(Book book) {
        return convert(book, BookPayload.class);
    }

    default Book convert(BookPayload book) {
        return convert(book, Book.class);
    }

    default Genre convert(GenrePayload genre) {
        return convert(genre, Genre.class);
    }

    default GenrePayload convert(Genre genre) {
        return convert(genre, GenrePayload.class);
    }

    default AuthorPayload convert(Author author) {
        return convert(author, AuthorPayload.class);
    }

    default Author convert(AuthorPayload author) {
        return convert(author, Author.class);
    }

}
