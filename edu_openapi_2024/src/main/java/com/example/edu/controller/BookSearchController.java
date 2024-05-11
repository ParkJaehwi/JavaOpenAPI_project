package com.example.edu.controller;//package com.example.edu.controller;

import com.example.edu.model.BookInfoVO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookSearchController {

    @RequestMapping(value = "/food")
    public String bookSearchPage() throws Exception {
        return "book";
    }

    @RequestMapping(value = "/foodsearch")
    public String bookSearchList(String keyword, Model model) {
        String url = "https://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1?ServiceKey=DsUAduFiNXosF4vwy50AMcCRk9sYGUOEuVAXTab4UL%2BxhoqapEvU33LLFozTQYcRSVmIkGqX4Xke5XheHQIAwg%3D%3D&numOfRows=100&type=json&desc_kor=" + keyword;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);


        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(result);
            JsonNode items = root.path("body").path("items");

            List<BookInfoVO> books = new ArrayList<>();
            for (JsonNode item : items) {
                BookInfoVO book = new BookInfoVO();
                book.setDescKor(item.path("DESC_KOR").asText());
                book.setServingWt(item.path("SERVING_WT").asText());
                book.setNutrCont1(item.path("NUTR_CONT1").asText());
                book.setNutrCont2(item.path("NUTR_CONT2").asText());
                book.setNutrCont3(item.path("NUTR_CONT3").asText());
                book.setNutrCont4(item.path("NUTR_CONT4").asText());
                book.setNutrCont5(item.path("NUTR_CONT5").asText());
                book.setNutrCont6(item.path("NUTR_CONT6").asText());
                book.setNutrCont7(item.path("NUTR_CONT7").asText());
                book.setNutrCont8(item.path("NUTR_CONT8").asText());
                book.setNutrCont9(item.path("NUTR_CONT9").asText());
                book.setBgnYear(item.path("BGN_YEAR").asText());
                book.setAnimalPlant(item.path("ANIMAL_PLANT").asText());

                books.add(book);
            }

            model.addAttribute("books", books);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "bookSearchResult";
    }
}