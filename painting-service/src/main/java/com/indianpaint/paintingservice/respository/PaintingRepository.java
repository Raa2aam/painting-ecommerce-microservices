package com.indianpaint.paintingservice.respository;

import com.indianpaint.paintingservice.entity.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintingRepository extends JpaRepository<Painting, Integer> {
}
