package prac.E_beforeJPA;

import com.example.springadvanced.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

//    @Bean
//    public ProductRepository productRepository() {
//        String dbUrl = "jdbc:h2:mem:springcoredb";
//        String dbId = "sa";
//        String dbPassword = "";
//
//        return new ProductRepository(dbUrl, dbId, dbPassword);
//    }
//
//    static class BeforeOverlapProductController {

   //
   //
   //    // 신규 상품 등록
   //    @PostMapping("/api/products")
   //    public Product createProduct(@RequestBody ProductRequestDto requestDto) throws SQLException {
   //        BeforeOverlapProductService productService = new BeforeOverlapProductService();
   //        Product product = productService.createProduct(requestDto);
   //
   //        // 응답 보내기
   //        return product;
   //    }
   //
   //    // 설정 가격 변경
   //    @PutMapping("/api/products/{id}")
   //    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) throws SQLException {
   //        BeforeOverlapProductService productService = new BeforeOverlapProductService();
   //        Product product = productService.updateProduct(id, requestDto);
   //
   //        // 응답 보내기 (업데이트된 상품 id)
   //        return product.getId();
   //    }
   //
   //    // 등록된 전체 상품 목록 조회
   //    @GetMapping("/api/products")
   //    public List<Product> getProducts() throws SQLException {
   //        BeforeOverlapProductService productService = new BeforeOverlapProductService();
   //        List<Product> products = productService.getProducts();
   //
   //        // 응답 보내기
   //        return products;
   //    }
//   }

    public static class BeforeOverlapProductService {
    //
    //    public Product createProduct(ProductRequestDto requestDto) throws SQLException {
    //        // 요청받은 DTO 로 DB에 저장할 객체 만들기
    //        Product product = new Product(requestDto);
    //
    //        ProductRepository productRepository = new ProductRepository();
    //        productRepository.createProduct(product);
    //
    //        return product;
    //    }
    //
    //    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) throws SQLException {
    //        ProductRepository productRepository = new ProductRepository();
    //        Product product = productRepository.getProduct(id);
    //        if (product == null) {
    //            throw new NullPointerException("해당 아이디가 존재하지 않습니다.");
    //        }
    //
    //        int myprice = requestDto.getMyprice();
    //        productRepository.updateMyprice(id, myprice);
    //
    //        return product;
    //    }
    //
    //    public List<Product> getProducts() throws SQLException {
    //        ProductRepository productRepository = new ProductRepository();
    //        List<Product> products = productRepository.getProducts();
    //
    //        return products;
    //    }
    }
}

//스프링이 실행될 때 자동으로 객체를 호출해준다.
// 1. @Bean 설정된 함수 호출
//ProductRepository productRepository = beanConfiguration.productRepository();

// 2. 스프링 IoC 컨테이너에 빈 (productRepository) 저장
// productRepository -> 스프링 IoC 컨테이너


