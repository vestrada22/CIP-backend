package com.poli.integracion.continua.backend.models.dto;

import lombok.Data;

@Data
public class AuthorDetailsDTO {

    private String name;
    private String username;
    private String avatar_path;
    private Double rating;
}
