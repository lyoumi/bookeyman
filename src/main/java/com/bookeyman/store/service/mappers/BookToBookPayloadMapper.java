package com.bookeyman.store.service.mappers;

import com.bookeyman.store.data.BookPayload;
import com.bookeyman.store.entity.Book;
import org.mapstruct.Mapper;

import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface BookToBookPayloadMapper extends Converter<Book, BookPayload> {

}
