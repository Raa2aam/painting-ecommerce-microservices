package com.indianpaint.paintingservice.controller;

import com.indianpaint.paintingservice.dto.PaintingRequestDTO;
import com.indianpaint.paintingservice.dto.PaintingResponseDTO;
import com.indianpaint.paintingservice.service.PaintingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paintings")
public class PaintingController {

    private final PaintingService paintingService;

    public PaintingController(PaintingService paintingService) {
        this.paintingService = paintingService;
    }

    @PostMapping
    public PaintingResponseDTO createPainting(
            @Valid @RequestBody PaintingRequestDTO dto) {

        return paintingService.createPainting(dto);
    }

    @GetMapping("/{id}")
    public PaintingResponseDTO getPaintingById(@PathVariable Long id) {
        return paintingService.getPaintingById(id);
    }

    @GetMapping
    public List<PaintingResponseDTO> getAllPaintings() {
        return paintingService.getAllPaintings();
    }

    @PutMapping("/{id}")
    public PaintingResponseDTO updatePainting(
            @PathVariable Long id,
            @Valid @RequestBody PaintingRequestDTO dto) {

        return paintingService.updatePainting(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletePainting(@PathVariable Long id) {
        paintingService.deletePainting(id);
    }
}