package com.example.springadvanced.repository;

import com.example.springadvanced.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByUserId(Long userId);
}
//jpa 문서보는 법 : 마우스오른쪽-go to-implement