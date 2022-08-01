package prac.E_beforeJPA;
import org.springframework.stereotype.Component;

@Component
public class BeforeJPAProductService {
//
//    private final ProductRepository productRepository;
//
//    @Autowired
//    public BeforeJPAProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    //@Bean을 수동으로 가져오는 방법
////    @Autowired
////    public ProductService(ApplicationContext context) {
////        // 1.'빈' 이름으로 가져오기
////        //BeanConfiguration에서 가져옴
////        //ProductRepository productRepository = (ProductRepository) context.getBean("productRepository");
////        // 2.'빈' 클래스 형식으로 가져오기
////        ProductRepository productRepository = context.getBean(ProductRepository.class);
////        this.productRepository = productRepository;
////    }
//
//
//    public Product createProduct(ProductRequestDto requestDto) throws SQLException {
//        // 요청받은 DTO 로 DB에 저장할 객체 만들기
//        Product product = new Product(requestDto);
//          //ProductRepository productRepository = new ProductRepository();
//        productRepository.createProduct(product);
//
//        return product;
//    }
//
//    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) throws SQLException {
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
//        List<Product> products = productRepository.getProducts();
//
//        return products;
//    }
}