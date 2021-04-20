USE bookstore;

CREATE TABLE IF NOT EXISTS book_products (
    id varchar(255) NOT NULL PRIMARY KEY,
    price double NOT NULL,
    count INTEGER NOT NULL,
    book_id VARCHAR(255),
    is_disabled INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS books (
    id varchar(255) NOT NULL PRIMARY KEY,
    title varchar(255) NOT NULL,
    publisher_id varchar(255),
    pages INTEGER NOT NULL,
    publishing_year INTEGER
);

CREATE TABLE IF NOT EXISTS publishers (
    id varchar(255) NOT NULL PRIMARY KEY,
    title varchar(255),
    country varchar(255),
    city varchar(255)
);

CREATE TABLE IF NOT EXISTS genres (
    id varchar(255) NOT NULL PRIMARY KEY,
    name varchar(255)
);

CREATE TABLE IF NOT EXISTS authors (
    id varchar(255) NOT NULL PRIMARY KEY,
    name varchar(255)
);

CREATE TABLE IF NOT EXISTS books_genres (
    id varchar(255) NOT NULL PRIMARY KEY,
    book_id varchar(255),
    genre_id varchar(255)
);

CREATE TABLE IF NOT EXISTS books_authors (
    id varchar(255) NOT NULL PRIMARY KEY,
    book_id varchar(255),
    author_id varchar(255)
);

ALTER TABLE book_products
ADD CONSTRAINT fk_product_book
FOREIGN KEY (book_id) REFERENCES books(id);

ALTER TABLE books
ADD CONSTRAINT fk_book_publisher
FOREIGN KEY (publisher_id) REFERENCES publishers(id);

ALTER TABLE books_genres
ADD CONSTRAINT fk_book_genre
FOREIGN KEY (book_id) REFERENCES books(id);

ALTER TABLE books_genres
ADD CONSTRAINT fk_genre_book
FOREIGN KEY (genre_id) REFERENCES genres(id);

ALTER TABLE books_authors
ADD CONSTRAINT fk_book_author
FOREIGN KEY (book_id) REFERENCES books(id);

ALTER TABLE books_authors
ADD CONSTRAINT fk_author_book
FOREIGN KEY (author_id) REFERENCES authors(id);
