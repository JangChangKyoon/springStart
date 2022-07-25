package com.api.springapiprac.Controller;

//키워드로 상품 검색하고 그 결과를 목록으로 보여주기	GET	/api/search?query=검색어


import com.api.springapiprac.models.ItemDto;
import com.api.springapiprac.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor // final 로 선언된 클래스를 자동으로 생성합니다.
@RestController // JSON으로 응답함을 선언합니다.
public class SearchRequestController {

    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/search")//네이버 API참고
    //@RequestParam 변수로 온 것을 자동으로 입력해줌
    public List<ItemDto> getItems(@RequestParam String query) {
        String resultString = naverShopSearch.search(query);
        return naverShopSearch.fromJSONtoItems(resultString);
    }
}

