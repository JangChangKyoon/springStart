
//API설계
//키워드로 상품 검색하고 그 결과를 목록으로 보여주기	GET	/api/search?query=검색어	List<ItemDto>
//관심 상품 등록하기	POST	/api/products	Product
//관심 상품 조회하기	GET	/api/products	List<Product>
//관심 상품에 관심 가격 등록하고, 그 가격보다 낮은 경우 표시하기 (숙제!)	PUT	/api/products/{id}	id

//- 3계층 설계하기
//1. Controller(Controller 패키지)
//- ProductRestController: 관심 상품 관련 컨트롤러
//- SearchRequestController: 검색 관련 컨트롤러
//2. Service
//- ProductService: 관심 상품 가격 변경
//3. Repository(model 패키지)
//👉 여기서 DB에 저장되는 녀석은 Product 뿐이라는 점!
//- Product: 관심 상품 테이블 및 맴버변수 설정
//- ProductRepository: 관심 상품 조회, 저장
//- ProductRequestDto: 관심 상품 등록하기
//- ProductMypriceRequestDto: 관심 가격 변경하기
//- ItemDto: 검색 결과 주고받기


//1. 관심상품 조회하기
//    producRestController : 관심상품 응답 처리
//    Product : 맵버변수 설정
//    ProductRepository : 관심상품 조회, 저장
//    Timestamped
//    main 설정
//2. 관심상품등록하기
//    ProductRequestDto: 관심 상품 등록하기
//    ProductMypriceRequestDto: 관심 가격 변경하기
//    product 보강 : Product(ProductRequestDto requestDto), update(ProductMypriceRequestDto requestDto)
//    ProductSevice 업데이트
//    producRestController 개선 : Product createProduct
//    main 네이버쇼핑 검색어 바꾸기
//검색 결과를 문자열에서 DTO로 바꾸기
//    - org.json 패키지 설치
//        1. 구글에 maven repo 검색 후 첫 번째 결과 클릭
//        2. 검색창에 json 입력 후 엔터
//        3. JSON In Java 클릭
//        4. 숫자 가장 높은 버전 클릭
//        5. Gradle 탭 클릭
//        6. 내용 복사하여 build.gradle > dependencies 안에 붙여넣기
//        7. dependencies 옆의 Run 버튼 클릭
//        8. 에디터 오른쪽 탭 gradle 새로고침
//    ItemDto 생성하기
//    romJSONtoItems 메소드 만들기
//키워드로 상품 검색하기 - 네이버 API와 서비스 연결하기
//        1. 사용자가 검색어를 입력하면, 컨트롤러가 그것을 전달받습니다.
//        2. 전달받은 검색어로 네이버 API에 요청하고, 그 결과를 사용자에게 응답합니다.
//    NaverShopSearch 컴포넌트 등록하기
//      @Component입력(스프링에 권한 주기)
//    SearchRequestController 만들기
//상품 검색 기능 만들기
//    execSearch, addHTML 함수 만들기
//    검색창 입력값 가져오기 let query = $('#query').val();
//        브라우저에서 검사를 눌러서 태그(query) 확인
//    색창 입력값을 검사하고, 입력하지 않았을 경우 $('#query').focus();
//    GET /api/search?query=${query} 요청
//    for 문마다 itemDto를 꺼내서 HTML 만들고 검색결과 목록에 붙이기!$('#search-result-box').append(tempHtml);
//    addHTML 완성하기function addHTML(itemDto)
//    execSearch, addHTML 완성
//관심 상품 등록하기
//        관심 상품 생성 요청addProduct(itemDto)
//        modal 뜨게 하기
//        targetId = response.id
//        addProduct 함수 완성

package com.api.springapiprac.models; //function execSearch()

import com.api.springapiprac.models.ProductMypriceRequestDto;
import com.api.springapiprac.models.ProductRequestDto;
import com.api.springapiprac.models.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Product extends Timestamped{

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;

    // 관심 상품 생성 시 이용합니다.
    // 선행작업 DTO
    public Product(ProductRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.image = requestDto.getImage();
        this.link = requestDto.getLink();
        this.lprice = requestDto.getLprice();
        this.myprice = 0;
    }

    // 관심 가격 변경 시 이용합니다.
    // 선행작업 DTO
    public void update(ProductMypriceRequestDto requestDto) {
        this.myprice = requestDto.getMyprice();
    }
}


