package com.bookeyman.store.service.mappers;

import com.bookeyman.store.data.AuthorPayload;
import com.bookeyman.store.data.BookPayload;
import com.bookeyman.store.data.BookProductPayload;
import com.bookeyman.store.data.GenrePayload;
import com.bookeyman.store.entity.Author;
import com.bookeyman.store.entity.Book;
import com.bookeyman.store.entity.BookProduct;
import com.bookeyman.store.entity.Genre;

public interface ConverterService {

    <T> T convert(Object source, Class<T> targetClass);

    default BookPayload convert(Book source) {
        return convert(source, BookPayload.class);
    }

    default Book convert(BookPayload source) {
        return convert(source, Book.class);
    }

    default Genre convert(GenrePayload source) {
        return convert(source, Genre.class);
    }

    default GenrePayload convert(Genre source) {
        return convert(source, GenrePayload.class);
    }

    default AuthorPayload convert(Author source) {
        return convert(source, AuthorPayload.class);
    }

    default Author convert(AuthorPayload source) {
        return convert(source, Author.class);
    }

    default BookProduct convert(BookProductPayload source) {
        return convert(source, BookProduct.class);
    }

    default BookProductPayload convert(BookProduct source) {
        return convert(source, BookProductPayload.class);
    }

}
