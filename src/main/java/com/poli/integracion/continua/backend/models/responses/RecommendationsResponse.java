package com.poli.integracion.continua.backend.models.responses;

import com.poli.integracion.continua.backend.models.dto.RecommendationDTO;
import lombok.Data;

import java.util.List;

@Data
public class RecommendationsResponse {

    private int page;

    private int total_pages;

    private int total_results;

    private List<RecommendationDTO> results;
}
