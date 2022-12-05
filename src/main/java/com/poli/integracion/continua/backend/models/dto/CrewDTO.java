package com.poli.integracion.continua.backend.models.dto;

import com.poli.integracion.continua.backend.models.responses.RecommendationsResponse;
import lombok.Data;

@Data
public class CrewDTO {

    private Long id;
    private Boolean adult;
    private Long gender;

    private String known_for_department;
    private String name;
    private String original_name;
    private Double popularity;
    private String profile_path;
    private String credit_id;
    private String department;
    private String job;
}
