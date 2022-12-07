package com.poli.integracion.continua.backend.models.responses;

import com.poli.integracion.continua.backend.models.dto.ReviewDTO;
import lombok.Data;

import java.util.List;

@Data
public class ReviewResponse {
    private Long id;
    private Integer page;
    private Integer total_pages;
    private Integer total_results;
    private List<ReviewDTO> results;
}
