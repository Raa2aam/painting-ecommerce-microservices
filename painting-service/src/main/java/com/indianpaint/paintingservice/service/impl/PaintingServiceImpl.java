package com.indianpaint.paintingservice.service.impl;

import com.indianpaint.paintingservice.entity.Painting;
import com.indianpaint.paintingservice.respository.PaintingRepository;
import com.indianpaint.paintingservice.service.PaintingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaintingServiceImpl implements PaintingService {

    private final PaintingRepository paintingRepository;

    PaintingServiceImpl(PaintingRepository paintingRepository){
        this.paintingRepository = paintingRepository;
    }

    public Painting createPainting(Painting painting) {
        return paintingRepository.save(painting);
    }


    public List<Painting> getAllPaintings() {
        return paintingRepository.findAll();
    }


    public Painting getPaintingById(int id) {
        return paintingRepository.findById(id).orElse(null);
    }


    public Painting updatePainting(int id, Painting updatedPainting) {
        Painting existingPainting = paintingRepository.findById(id).orElse(null);

        if(existingPainting == null){
            return null;
        }
        existingPainting.setTitle(updatedPainting.getTitle());
        existingPainting.setArtist(updatedPainting.getArtist());
        existingPainting.setDescription(updatedPainting.getDescription());
        existingPainting.setPrice(updatedPainting.getPrice());
        existingPainting.setQuantity(updatedPainting.getQuantity());
        existingPainting.setImageUrl(updatedPainting.getImageUrl());

        return paintingRepository.save(existingPainting);
    }


    public void deletePainting(int id) {
        paintingRepository.deleteById(id);
    }
}
