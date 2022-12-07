package com.poli.integracion.continua.backend.models.dto;

import lombok.Data;

@Data
public class ReviewDTO {

    private String author;
    private AuthorDetailsDTO author_details;
    private String content;
    private String created_at;
    private String id;
    private String updated_at;
    private String url;
}
