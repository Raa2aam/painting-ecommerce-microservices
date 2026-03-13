package com.indianpaint.paintingservice.service.impl;

import com.indianpaint.paintingservice.dto.PaintingRequestDTO;
import com.indianpaint.paintingservice.dto.PaintingResponseDTO;
import com.indianpaint.paintingservice.entity.Painting;
import com.indianpaint.paintingservice.exception.ResourceNotFoundException;
import com.indianpaint.paintingservice.respository.PaintingRepository;
import com.indianpaint.paintingservice.service.PaintingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaintingServiceImpl implements PaintingService {

    private final PaintingRepository repository;

    public PaintingServiceImpl(PaintingRepository repository) {
        this.repository = repository;
    }

    @Override
    public PaintingResponseDTO createPainting(PaintingRequestDTO dto) {

        Painting painting = new Painting();

        painting.setTitle(dto.getTitle());
        painting.setArtist(dto.getArtist());
        painting.setPrice(dto.getPrice());
        painting.setQuantity(dto.getQuantity());
        painting.setDescription(dto.getDescription());
        painting.setImageUrl(dto.getImageUrl());

        Painting savedPainting = repository.save(painting);

        return convertToDTO(savedPainting);
    }

    @Override
    public PaintingResponseDTO getPaintingById(Long id) {

        Painting painting = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Painting not found with id: " + id));

        return convertToDTO(painting);
    }

    @Override
    public List<PaintingResponseDTO> getAllPaintings() {

        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PaintingResponseDTO updatePainting(Long id, PaintingRequestDTO dto) {

        Painting painting = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Painting not found with id: " + id));

        painting.setTitle(dto.getTitle());
        painting.setArtist(dto.getArtist());
        painting.setPrice(dto.getPrice());
        painting.setQuantity(dto.getQuantity());
        painting.setDescription(dto.getDescription());
        painting.setImageUrl(dto.getImageUrl());

        Painting updated = repository.save(painting);

        return convertToDTO(updated);
    }

    @Override
    public void deletePainting(Long id) {

        Painting painting = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Painting not found with id: " + id));

        repository.delete(painting);
    }

    private PaintingResponseDTO convertToDTO(Painting painting) {

        return PaintingResponseDTO.builder()
                .id(painting.getId())
                .title(painting.getTitle())
                .artist(painting.getArtist())
                .price(painting.getPrice())
                .quantity(painting.getQuantity())
                .description(painting.getDescription())
                .imageUrl(painting.getImageUrl())
                .build();
    }
}