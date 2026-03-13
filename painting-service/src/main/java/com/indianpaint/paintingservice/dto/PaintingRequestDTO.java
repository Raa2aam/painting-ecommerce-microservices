package com.indianpaint.paintingservice.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PaintingRequestDTO {

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Artist cannot be empty")
    private String artist;

    @NotNull
    @Positive
    private Double price;

    @NotNull
    @Min(0)
    private Integer quantity;

    private String description;

    private String imageUrl;
}