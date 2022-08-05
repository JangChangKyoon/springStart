package com.example.springadvanced.repository;

import com.example.springadvanced.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {


}
