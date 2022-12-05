package com.poli.integracion.continua.backend.services.interfaces.movie;

import com.poli.integracion.continua.backend.models.dto.MovieDTO;
import com.poli.integracion.continua.backend.models.responses.RecommendationsResponse;

import java.io.IOException;
import java.net.URISyntaxException;


public interface IMovieService {

    RecommendationsResponse recommendationsMovie(Integer idMovie, String query, String language, int page) throws URISyntaxException;

    MovieDTO movie(int idMovie) throws IOException, URISyntaxException;

}

