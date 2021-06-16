package com.bookeyman.store.repository;

import com.bookeyman.store.entity.BookProduct;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookProductRepository extends JpaRepository<BookProduct, String> {

    List<BookProduct> findAllByIsDisabledIsFalse();
}
