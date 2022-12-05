package com.poli.integracion.continua.backend.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MovieDTO {

    private Long id;

    private String title;

    private Boolean adult;

    private String backdrop_path;

    private String belongs_to_collection; //TODO: Verificar el campo

    private Double budget;

//    private GenresEntity genres;

    private String homepage;

    private String imdb_id;

    private String original_language;

    private String original_title;

    private String overview;

    private Double popularity;

    private String poster_path;

//    private ProductionCompaniesEntity production_companies;

//    private ProductionCountriesEntity production_countries;

    private Date release_date;

    private Double revenue;

    private Double runtime;

    private String status;

    private String tagline;

    private Boolean video;

    private Double vote_average;

    private Double vote_count;
}
