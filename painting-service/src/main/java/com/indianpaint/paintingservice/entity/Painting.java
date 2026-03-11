package com.indianpaint.paintingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Painting {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String artist;
    private Double price;
    private Integer quantity;
    private String description;
    private String imageUrl;

}
