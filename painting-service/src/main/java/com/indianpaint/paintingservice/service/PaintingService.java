package com.indianpaint.paintingservice.service;

import com.indianpaint.paintingservice.entity.Painting;

import java.util.List;


public interface PaintingService {

    Painting createPainting(Painting painting);
     List<Painting> getAllPaintings();
     Painting getPaintingById(int id);
     Painting updatePainting(int id, Painting painting);
     void deletePainting(int id);

}
