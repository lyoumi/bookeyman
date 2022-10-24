package com.bookeyman.store.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookProductPayload {

    @JsonProperty
    private String id;

    @JsonProperty
    private Double price;

    @JsonProperty
    private Integer count;

    @JsonProperty
    private BookPayload book;
}
