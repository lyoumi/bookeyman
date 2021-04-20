package com.bookeyman.store.service.mappers;

import com.bookeyman.store.data.GenrePayload;
import com.bookeyman.store.entity.Genre;
import org.mapstruct.Mapper;

import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface GenreToGenrePayloadMapper extends Converter<Genre, GenrePayload> {

}
