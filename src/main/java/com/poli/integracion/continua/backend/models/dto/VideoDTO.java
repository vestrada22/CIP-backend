package com.poli.integracion.continua.backend.models.dto;

import lombok.Data;

@Data
public class VideoDTO {
    private String iso_639_1;
    private String iso_3166_1;
    private String name;
    private String key;
    private String site;
    private Long size;
    private String type;
    private Boolean official;
    private String published_at;
    private String id;
}
