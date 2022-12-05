package com.poli.integracion.continua.backend.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RecommendationDTO {

    private Long id;
    private String title;
    private Boolean adult;
    private String backdrop_path;
    private String original_language;
    private String original_title;
    private String overview;
    private String poster_path;
    private String media_type;
    private Double budget;
//    private GenresEntity genres;
    private String homepage;
    private String imdb_id;
    private Double popularity;
//    private Date release_date;
    private Boolean video;
    private Double vote_average;
    private Double vote_count;

}
