package com.example.springadvanced;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

    // 멤버 변수 선언
    private final ProductRepository productRepository;

    // 생성자: ProductService() 가 생성될 때 호출됨
    public ProductService() {
        // 멤버 변수 생성
        this.productRepository = new ProductRepository();
    }


    public Product createProduct(ProductRequestDto requestDto) throws SQLException {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto);

        //ProductRepository productRepository = new ProductRepository();
        this.productRepository.createProduct(product);

        return product;
    }

    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) throws SQLException {
        //ProductRepository productRepository = new ProductRepository();
        Product product = this.productRepository.getProduct(id);
        if (product == null) {
            throw new NullPointerException("해당 아이디가 존재하지 않습니다.");
        }

        int myprice = requestDto.getMyprice();
        this.productRepository.updateMyprice(id, myprice);

        return product;
    }

    public List<Product> getProducts() throws SQLException {
        //ProductRepository productRepository = new ProductRepository();
        List<Product> products = this.productRepository.getProducts();

        return products;
    }
}
