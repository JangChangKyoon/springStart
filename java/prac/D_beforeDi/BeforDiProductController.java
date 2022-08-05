package prac.D_beforeDi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class BeforDiProductController {
//
//
//    private final BeforDiProductService beforDiProductService;
//
//    //이렇게 선언해주면 소속 매소드에 모두 포함되는 건지?
//    public BeforDiProductController() {
//        BeforDiProductService productService = new BeforDiProductService();
//        this.beforDiProductService = productService;
//    }
//
//    // 신규 상품 등록
//    @PostMapping("/api/products")
//    public Product createProduct(@RequestBody ProductRequestDto requestDto) throws SQLException {
//        //ProductService = new ProductService();
//        Product product = beforDiProductService.createProduct(requestDto);
//
//        // 응답 보내기
//        return product;
//    }
//
//    // 설정 가격 변경
//    @PutMapping("/api/products/{id}")
//    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) throws SQLException {
//        //ProductService productService = new ProductService();
//        Product product = beforDiProductService.updateProduct(id, requestDto);
//
//        // 응답 보내기 (업데이트된 상품 id)
//        return product.getId();
//    }
//
//    // 등록된 전체 상품 목록 조회
//    @GetMapping("/api/products")
//    public List<Product> getProducts() throws SQLException {
//        //ProductService productService = new ProductService();
//        List<Product> products = beforDiProductService.getProducts();
//
//        // 응답 보내기
//        return products;
//    }
}