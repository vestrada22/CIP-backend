package com.poli.integracion.continua.backend.models.responses;

import com.poli.integracion.continua.backend.models.dto.KeywordDTO;
import lombok.Data;

import java.util.List;

@Data
public class KeywordResponse {
    private Long id;

    private List<KeywordDTO> keywords;
}
