package com.indianpaint.paintingservice.service;

import com.indianpaint.paintingservice.dto.PaintingRequestDTO;
import com.indianpaint.paintingservice.dto.PaintingResponseDTO;

import java.util.List;

public interface PaintingService {

    PaintingResponseDTO createPainting(PaintingRequestDTO dto);

    PaintingResponseDTO getPaintingById(Long id);

    List<PaintingResponseDTO> getAllPaintings();

    PaintingResponseDTO updatePainting(Long id, PaintingRequestDTO dto);

    void deletePainting(Long id);
}