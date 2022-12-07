package com.poli.integracion.continua.backend.models.responses;

import com.poli.integracion.continua.backend.models.dto.CastDTO;
import com.poli.integracion.continua.backend.models.dto.CrewDTO;
import lombok.Data;

import java.util.List;

@Data
public class CreditsResponse {
    private Long id;
    private List<CastDTO> cast;
    private List<CrewDTO> crew;
}
