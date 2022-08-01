package prac.F_JpaAdded.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prac.F_JpaAdded.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> { }
//jpa 문서보는 법 : 마우스오른쪽-go to-implement