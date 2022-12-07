package com.poli.integracion.continua.backend.models.responses;

import com.poli.integracion.continua.backend.models.dto.VideoDTO;
import lombok.Data;

import java.util.List;

@Data
public class VideoResponse {
    private Long id;
    private List<VideoDTO> results;
}
