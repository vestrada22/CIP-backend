package com.poli.integracion.continua.backend.models.responses;

import com.poli.integracion.continua.backend.models.dto.DateDTO;
import com.poli.integracion.continua.backend.models.dto.MovieDTO;
import lombok.Data;

import java.util.List;

@Data
public class NowPlayingResponse {

    private DateDTO dates;
    private Integer page;
    private List<MovieDTO> results;
    private Integer total_pages;
    private Integer total_results;
}
