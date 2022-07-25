package com.api.springapiprac.Controller;

import com.api.springapiprac.models.Product;
import com.api.springapiprac.models.ProductRepository;
import com.api.springapiprac.models.ProductRequestDto;
import com.api.springapiprac.sevice.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ProductRestController {

    private final ProductRepository productRepository;
    private final ProductService productService;


    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts() {
        //productRepository를 알아내기 위해 위 private final 맴버변수를 선언해주어야 한다.
        return productRepository.findAll();
    }

    // 신규 상품 등록
    @PostMapping("/api/products")
    //@RequestBody 파라미터에 변수 전달
    public Product createProduct(@RequestBody ProductRequestDto requestDto) {
        Product product = new Product(requestDto);
        productRepository.save(product);
        return product;
    }
}