package com.api.springapiprac.utils;

import com.api.springapiprac.models.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class NaverShopSearch {
    //(String query) : 검색어를 받는다. -> rest.exchange에 반영
    public String search(String query) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "_yRjVbEdaZlbmDcJ7NZF");
        headers.add("X-Naver-Client-Secret", "Lvi9xFnEeA");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    public List<ItemDto> fromJSONtoItems(String result) {
        JSONObject rjson = new JSONObject(result);
        JSONArray items  = rjson.getJSONArray("items");
        List<ItemDto> ret = new ArrayList<>();
        for (int i=0; i<items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i);
            System.out.println(itemJson);
            ItemDto itemDto = new ItemDto(itemJson);
            ret.add(itemDto);
        }
        return ret;
    }


    public static void main(String[] args) {
        NaverShopSearch naverShopSearch = new NaverShopSearch();
        String itemDtoList = naverShopSearch.search("아이맥");
        naverShopSearch.fromJSONtoItems(itemDtoList);
    }

}



//    public static void main(String[] args) {
//        NaverShopSearch naverShopSearch = new NaverShopSearch();
//        String result = naverShopSearch.search("아이맥");
        //JSONObject 라이브러리 활용 json 문자열 변환
//        JSONObject rjson = new JSONObject(result);
//        System.out.println(result);
        // JSONObject 라이브러리 활용한 배열 꺼내기
//        JSONArray items = rjson.getJSONArray("items");
//        List<ItemDto> itemDtoList = new ArrayList<>();
//        for (int i=0; i<items.length(); i++) {
//            JSONObject itemJson = (JSONObject) items.get(i);
//            ItemDto itemDto = new ItemDto(itemJson);
//            itemDtoList.add(itemDto);
//          Dto를 사용하지 않은 경우
//            System.out.println(itemJson);
//            String title = itemJson.getString("title");
//            int lprice = itemJson.getInt("lprice");
//            System.out.println(lprice);

//    }



