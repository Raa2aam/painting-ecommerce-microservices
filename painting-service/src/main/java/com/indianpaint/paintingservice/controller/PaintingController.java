package com.indianpaint.paintingservice.controller;

import com.indianpaint.paintingservice.entity.Painting;
import com.indianpaint.paintingservice.service.PaintingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paintings")
public class PaintingController {

    private final PaintingService service;

    PaintingController(PaintingService service){
        this.service = service;
    }

    @PostMapping
    public Painting createPainting(@RequestBody Painting painting){
        return service.createPainting(painting);

    }

    @GetMapping
    public List<Painting> getPainting(){
        return service.getAllPaintings();
    }

    @GetMapping("/{id}")
    public Painting getPaintingByid(@PathVariable int id){
        return service.getPaintingById(id);
    }

    @PutMapping("/{id}")
    public Painting updatePainting(@PathVariable int id, @RequestBody Painting painting){
        return service.updatePainting(id, painting);
    }

    @DeleteMapping("/{id}")
    public void deletePainting(@PathVariable int id){
         service.deletePainting(id);
    }
}
