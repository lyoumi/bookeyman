package com.bookeyman.store.repository;

import com.bookeyman.store.entity.BookProduct;
import reactor.core.publisher.Flux;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BookProductRepository extends ReactiveCrudRepository<BookProduct, String> {

    Flux<BookProduct> findAllByIsDisabledIsFalse();
}
