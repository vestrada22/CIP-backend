package com.poli.integracion.continua.backend.controllers;

import com.poli.integracion.continua.backend.models.dto.ExternalIdsDTO;
import com.poli.integracion.continua.backend.models.dto.MovieDTO;
import com.poli.integracion.continua.backend.models.responses.*;
import com.poli.integracion.continua.backend.services.interfaces.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URISyntaxException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/movie")
public class MovieController {

  @Autowired
  private IMovieService movieService;

  @GetMapping("/recommendations")
  public RecommendationsResponse RecommendationMovie(@RequestParam @Valid Integer idMovie, @RequestParam(required = false) String query, @RequestParam @Valid String language, @RequestParam @Valid Integer page) throws URISyntaxException {
    return movieService.recommendationsMovie(idMovie, query, language, page);
  }
  @GetMapping()
  public MovieDTO movie(@RequestParam @Valid Integer idMovie) throws IOException, URISyntaxException {
    return movieService.movie(idMovie);
  }

  @GetMapping("/credits")
  public CreditsResponse creditsMovie(@RequestParam @Valid Integer idMovie, @RequestParam(required = false) String query, @RequestParam @Valid String language, @RequestParam @Valid Integer page) throws URISyntaxException {
    return movieService.credits(idMovie, query, language, page);
  }

  @GetMapping("/external_ids")
  public ExternalIdsDTO externalIdsMovie(@RequestParam @Valid Integer idMovie, @RequestParam(required = false) String query, @RequestParam @Valid String language, @RequestParam @Valid Integer page) throws URISyntaxException {
    return movieService.externalId(idMovie, query, language, page);
  }

  @GetMapping("/videos")
  public VideoResponse videosMovie(@RequestParam @Valid Integer idMovie, @RequestParam(required = false) String query, @RequestParam @Valid String language, @RequestParam @Valid Integer page) throws URISyntaxException {
    return movieService.video(idMovie, query, language, page);
  }

  @GetMapping("/keywords")
  public KeywordResponse keywordsMovie(@RequestParam @Valid Integer idMovie, @RequestParam(required = false) String query, @RequestParam @Valid String language, @RequestParam @Valid Integer page) throws URISyntaxException {
    return movieService.keyword(idMovie, query, language, page);
  }

  @GetMapping("/reviews")
  public ReviewResponse reviewsMovie(@RequestParam @Valid Integer idMovie, @RequestParam(required = false) String query, @RequestParam @Valid String language, @RequestParam @Valid Integer page) throws URISyntaxException {
    return movieService.review(idMovie, query, language, page);
  }

  @GetMapping("/now_playing")
  public NowPlayingResponse nowPlaying(@RequestParam @Valid Integer idMovie, @RequestParam(required = false) String query, @RequestParam @Valid String language, @RequestParam @Valid Integer page) throws URISyntaxException {
    return movieService.nowPlaying(idMovie, query, language, page);
  }

}
