package com.bookeyman.store.repository;

import com.bookeyman.store.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {

}
