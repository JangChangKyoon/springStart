package com.example.springadvanced.controller;

import com.example.springadvanced.dto.ItemDto;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class ItemSearchController {

    // Controller 가 자동으로 해주는 일
// 1. API Request 의 파라미터 값에서 검색어 추출 -> query 변수
// 5. API Response 보내기
// 5.1) response 의 header 설정
// 5.2) response 의 body 설정
    @GetMapping("/api/search")
    @ResponseBody
    public List<ItemDto> getItems(@RequestParam String query) throws IOException {
// 2. 네이버 쇼핑 API 호출에 필요한 Header, Body 정리
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "zdqMoIkFaK8uKvC2oNY2");
        headers.add("X-Naver-Client-Secret", "LiZfsgtuD5");
        String body = "";
        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);

// 3. 네이버 쇼핑 API 호출 결과 -> naverApiResponseJson (JSON 형태)
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);
        String naverApiResponseJson = responseEntity.getBody();

// 4. naverApiResponseJson (JSON 형태) -> itemDtoList (자바 객체 형태)
// - naverApiResponseJson 에서 우리가 사용할 데이터만 추출 -> List<ItemDto> 객체로 변환
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode itemsNode = objectMapper.readTree(naverApiResponseJson).get("items");
        List<ItemDto> itemDtoList = objectMapper
                .readerFor(new TypeReference<List<ItemDto>>() {})
                .readValue(itemsNode);

        return itemDtoList;
    }
}



//1. HTTP request, response 처리를 위해 매번 작성해 줘야하는 중복코드들 생략 가능
//@Controller
//public class ItemSearchController {
//    @GetMapping("/api/search")
//    @ResponseBody
//    public List<ItemDto> getItems(@RequestParam String query) throws IOException {
//
//        // ...
//
//        return itemDtoList;
//    }
//}

//*******************위 코드는 아래 코드를 축소한 것임.

//@WebServlet(urlPatterns = "/api/search")
//public class ItemSearchServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String query = request.getParameter("query");
//
//        // ...
//
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = response.getWriter();
//        String itemDtoListJson = objectMapper.writeValueAsString(itemDtoList);
//        out.print(itemDtoListJson);
//        out.flush();
//    }
//}

//----------------------------------------------------------

//2. API 이름마다 파일을 만들 필요 없음
//    로그인 페이지	GET	/user/login	login 페이지
//    로그아웃 처리	GET	/user/logout	"/" 으로 redirect
//    회원 가입 페이지	GET	/user/signup	signup 페이지
//    회원 가입 처리	POST	/user/signup	"/" 으로 redirect
//
//@Controller
//public class UserController {
//    @GetMapping("/user/login")
//    public String login() {
//        // ...
//    }
//
//    @GetMapping("/user/logout")
//    public String logout() {
//        // ...
//    }
//
//    @GetMapping("/user/signup")
//    public String signup() {
//        // ...
//    }
//
//    @PostMapping("/user/signup")
//    public String registerUser(SignupRequestDto requestDto) {
//        // ...
//    }
//}
//
////*******************위 코드는 아래 코드를 축소한 것임.
//
//@WebServlet(urlPatterns = "/user/login")
//public class UserLoginServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//        // ...
//    }
//}
//@WebServlet(urlPatterns = "/user/logout")
//public class UserLogoutServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//        // ...
//    }
//}