
//API설계
//키워드로 상품 검색하고 그 결과를 목록으로 보여주기	GET	/api/search?query=검색어	List<ItemDto>
//관심 상품 등록하기	POST	/api/products	Product
//관심 상품 조회하기	GET	/api/products	List<Product>
//관심 상품에 관심 가격 등록하고, 그 가격보다 낮은 경우 표시하기 (숙제!)	PUT	/api/products/{id}	id
//
//        - 3계층 설계하기
//        1. Controller(Controller 패키지)
//        - ProductRestController: 관심 상품 관련 컨트롤러
//        - SearchRequestController: 검색 관련 컨트롤러
//        2. Service
//        - ProductService: 관심 상품 가격 변경
//        3. Repository(model 패키지)
//        👉 여기서 DB에 저장되는 녀석은 Product 뿐이라는 점!
//        - Product: 관심 상품 테이블 및 맴버변수 설정
//        - ProductRepository: 관심 상품 조회, 저장
//        - ProductRequestDto: 관심 상품 등록하기
//        - ProductMypriceRequestDto: 관심 가격 변경하기
//        - ItemDto: 검색 결과 주고받기



package com.api.springapiprac.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

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

    //사진
    @Column(nullable = false)
    private String image;

    //하이퍼링크
    @Column(nullable = false)
    private String link;

    //최저가
    @Column(nullable = false)
    private int lprice;

    //내가 설정한 가격
    @Column(nullable = false)
    private int myprice;
}
