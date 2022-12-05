package com.poli.integracion.continua.backend.services.interfaces.movie;

import com.poli.integracion.continua.backend.models.dto.ExternalIdsDTO;
import com.poli.integracion.continua.backend.models.dto.MovieDTO;
import com.poli.integracion.continua.backend.models.responses.*;

import java.io.IOException;
import java.net.URISyntaxException;


public interface IMovieService {

    RecommendationsResponse recommendationsMovie(Integer idMovie, String query, String language, int page) throws URISyntaxException;

    MovieDTO movie(int idMovie) throws IOException, URISyntaxException;

    CreditsResponse credits(Integer idMovie, String query, String language, Integer page) throws URISyntaxException;

    ExternalIdsDTO externalId(Integer idMovie, String query, String language, Integer page) throws URISyntaxException;

    VideoResponse video(Integer idMovie, String query, String language, Integer page) throws URISyntaxException;

    KeywordResponse keyword(Integer idMovie, String query, String language, Integer page) throws URISyntaxException;

    ReviewResponse review(Integer idMovie, String query, String language, Integer page) throws URISyntaxException;

    NowPlayingResponse nowPlaying(Integer idMovie, String query, String language, Integer page) throws URISyntaxException;

}

