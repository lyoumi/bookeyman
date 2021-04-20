package com.bookeyman.store.service.mappers;

import com.bookeyman.store.data.AuthorPayload;
import com.bookeyman.store.entity.Author;
import org.mapstruct.Mapper;

import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface AuthorPayloadToAuthorMapper extends Converter<AuthorPayload, Author> {

}
