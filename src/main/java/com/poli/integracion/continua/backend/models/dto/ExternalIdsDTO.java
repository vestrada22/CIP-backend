package com.poli.integracion.continua.backend.models.dto;

import lombok.Data;

@Data
public class ExternalIdsDTO {

    private Long id;
    private String imdb_id;
    private String wikidata_id;
    private String facebook_id;
    private String instagram_id;
    private String twitter_id;
}
