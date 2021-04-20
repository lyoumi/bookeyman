package com.bookeyman.store.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public final class GenrePayload {

    @JsonProperty
    private String id;
    @JsonProperty
    private String name;
}
