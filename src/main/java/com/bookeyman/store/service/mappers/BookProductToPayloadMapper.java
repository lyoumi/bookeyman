package com.bookeyman.store.service.mappers;

import com.bookeyman.store.data.BookProductPayload;
import com.bookeyman.store.entity.BookProduct;
import org.mapstruct.Mapper;

import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface BookProductToPayloadMapper extends Converter<BookProduct, BookProductPayload> {

    BookProductPayload convert(BookProduct bookProduct);
}
