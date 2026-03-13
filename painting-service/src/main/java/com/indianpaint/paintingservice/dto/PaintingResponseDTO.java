package com.indianpaint.paintingservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaintingResponseDTO {

    private Long id;

    private String title;

    private String artist;

    private Double price;

    private Integer quantity;

    private String description;

    private String imageUrl;
}