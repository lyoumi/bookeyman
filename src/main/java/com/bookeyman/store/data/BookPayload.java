package com.bookeyman.store.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public final class BookPayload {

    @JsonProperty
    private String id;
    @JsonProperty
    private String title;
    @JsonProperty
    private Integer pages;
    @JsonProperty
    private List<GenrePayload> genres;
    @JsonProperty
    private Double price;
    @JsonProperty
    private List<AuthorPayload> author;
}
