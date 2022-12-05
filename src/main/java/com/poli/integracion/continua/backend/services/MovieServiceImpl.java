package com.poli.integracion.continua.backend.services;

import com.google.gson.Gson;
import com.poli.integracion.continua.backend.models.dto.ExternalIdsDTO;
import com.poli.integracion.continua.backend.models.dto.MovieDTO;
import com.poli.integracion.continua.backend.models.responses.*;
import com.poli.integracion.continua.backend.services.interfaces.movie.IMovieService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class MovieServiceImpl implements IMovieService {

    private final String baseUrl = "https://api.themoviedb.org/3";

    private final String endPointUrl = "/movie/";

    private final String credentials = "42a67ee45ecb4bf75b4e88986b5acadd";
    @Override
    public RecommendationsResponse recommendationsMovie(Integer idMovie, String query, String language, int page) throws URISyntaxException {

        String result = null;
        HttpGet request = new HttpGet(baseUrl + endPointUrl + idMovie + "/recommendations"  );
        URI uri = new URIBuilder(request.getURI())
                .addParameter("api_key", credentials)
                .build();
        request.setURI(uri);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            if(response.getStatusLine().getStatusCode() != 200) {
                throw new Exception("¡El servicio no responde correctamente!");
            }

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(result, RecommendationsResponse.class);
    }

    @Override
    public MovieDTO movie(int idMovie) throws URISyntaxException {

        String result = null;
        HttpGet request = new HttpGet(baseUrl + endPointUrl + idMovie  );
        URI uri = new URIBuilder(request.getURI())
                .addParameter("api_key", credentials)
                .build();
        request.setURI(uri);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            if(response.getStatusLine().getStatusCode() != 200) {
                throw new Exception("¡El servicio no responde correctamente!");
            }

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(result, MovieDTO.class);
    }

    @Override
    public CreditsResponse credits(Integer idMovie, String query, String language, Integer page) throws URISyntaxException {
        String result = null;
        HttpGet request = new HttpGet(baseUrl + endPointUrl + idMovie + "/credits" );
        URI uri = new URIBuilder(request.getURI())
                .addParameter("api_key", credentials)
                .addParameter("query", query)
                .addParameter("language", language)
                .addParameter("page", page.toString())
                .build();
        request.setURI(uri);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            if(response.getStatusLine().getStatusCode() != 200) {
                throw new Exception("¡El servicio no responde correctamente!");
            }

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(result, CreditsResponse.class);
    }

    @Override
    public ExternalIdsDTO externalId(Integer idMovie, String query, String language, Integer page) throws URISyntaxException {
        String result = null;
        HttpGet request = new HttpGet(baseUrl + endPointUrl + idMovie + "/external_ids" );
        URI uri = new URIBuilder(request.getURI())
                .addParameter("api_key", credentials)
                .addParameter("query", query)
                .addParameter("language", language)
                .addParameter("page", page.toString())
                .build();
        request.setURI(uri);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            if(response.getStatusLine().getStatusCode() != 200) {
                throw new Exception("¡El servicio no responde correctamente!");
            }

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(result, ExternalIdsDTO.class);
    }

    @Override
    public VideoResponse video(Integer idMovie, String query, String language, Integer page) throws URISyntaxException {
        String result = null;
        HttpGet request = new HttpGet(baseUrl + endPointUrl + idMovie + "/videos" );
        URI uri = new URIBuilder(request.getURI())
                .addParameter("api_key", credentials)
                .addParameter("query", query)
                .addParameter("language", language)
                .addParameter("page", page.toString())
                .build();
        request.setURI(uri);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            if(response.getStatusLine().getStatusCode() != 200) {
                throw new Exception("¡El servicio no responde correctamente!");
            }

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(result, VideoResponse.class);
    }

    @Override
    public KeywordResponse keyword(Integer idMovie, String query, String language, Integer page) throws URISyntaxException {
        String result = null;
        HttpGet request = new HttpGet(baseUrl + endPointUrl + idMovie + "/keywords" );
        URI uri = new URIBuilder(request.getURI())
                .addParameter("api_key", credentials)
                .addParameter("query", query)
                .addParameter("language", language)
                .addParameter("page", page.toString())
                .build();
        request.setURI(uri);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            if(response.getStatusLine().getStatusCode() != 200) {
                throw new Exception("¡El servicio no responde correctamente!");
            }

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(result, KeywordResponse.class);
    }

    @Override
    public ReviewResponse review(Integer idMovie, String query, String language, Integer page) throws URISyntaxException {
        String result = null;
        HttpGet request = new HttpGet(baseUrl + endPointUrl + idMovie + "/reviews" );
        URI uri = new URIBuilder(request.getURI())
                .addParameter("api_key", credentials)
                .addParameter("query", query)
                .addParameter("language", language)
                .addParameter("page", page.toString())
                .build();
        request.setURI(uri);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            if(response.getStatusLine().getStatusCode() != 200) {
                throw new Exception("¡El servicio no responde correctamente!");
            }

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(result, ReviewResponse.class);
    }

    @Override
    public NowPlayingResponse nowPlaying(Integer idMovie, String query, String language, Integer page) throws URISyntaxException {
        String result = null;
        HttpGet request = new HttpGet(baseUrl + endPointUrl + "/now_playing" );
        URI uri = new URIBuilder(request.getURI())
                .addParameter("api_key", credentials)
                .addParameter("query", query)
                .addParameter("language", language)
                .addParameter("page", page.toString())
                .build();
        request.setURI(uri);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            if(response.getStatusLine().getStatusCode() != 200) {
                throw new Exception("¡El servicio no responde correctamente!");
            }

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(result, NowPlayingResponse.class);
    }
}
