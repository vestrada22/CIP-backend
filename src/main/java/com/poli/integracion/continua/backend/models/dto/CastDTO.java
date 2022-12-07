package com.poli.integracion.continua.backend.models.dto;

import lombok.Data;

@Data
public class CastDTO {
    private  Long id;
    private Boolean adult;
    private Long gender;
    private String known_for_department;
    private String name;
    private String original_name;
    private Double popularity;
    private String profile_path;
    private Long cast_id;
    private String character;
    private String credit_id;
    private Long order;
}
