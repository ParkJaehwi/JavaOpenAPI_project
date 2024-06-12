package com.example.edu.controller;

import com.example.edu.model.FoodInfoVO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;

import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



@Controller
public class FoodSearchController {

    private static final int ROWS_PER_PAGE = 20; // 한 페이지당 표시할 항목 수
    private static final String SERVICE_KEY = "DsUAduFiNXosF4vwy50AMcCRk9sYGUOEuVAXTab4UL%2BxhoqapEvU33LLFozTQYcRSVmIkGqX4Xke5XheHQIAwg%3D%3D";


    @RequestMapping(value = "/food")
    public String bookSearchPage() throws Exception {
        return "food";
    }

    @RequestMapping(value = "/foodsearch")
    public String foodSearchList(String keyword, Integer page, Model model) {
        if (page == null || page < 1) {
            page = 1;
        }
        StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1?ServiceKey=DsUAduFiNXosF4vwy50AMcCRk9sYGUOEuVAXTab4UL%2BxhoqapEvU33LLFozTQYcRSVmIkGqX4Xke5XheHQIAwg%3D%3D");
        try {
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + SERVICE_KEY);
            urlBuilder.append("&" + URLEncoder.encode("desc_kor", "UTF-8") + "=" + URLEncoder.encode(keyword, "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("20", "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(page), "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
        } catch (Exception e) {
            model.addAttribute("errorMessage", "URL 인코딩 에러가 발생했습니다.");
            return "foodSearchResult";
        }

        String url = urlBuilder.toString();

        try {
            URL apiURL = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) apiURL.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");

            int responseCode = conn.getResponseCode();
            BufferedReader rd;
            if (responseCode >= 200 && responseCode <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                model.addAttribute("errorMessage", "API 서버 에러입니다. 잠시 후 다시 이용해주세요.");
                return "foodSearchResult";
            }

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();

            String result = sb.toString();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(result);
            JsonNode items = root.path("body").path("items");
            JsonNode totalCountNode = root.path("body").path("totalCount");

            int totalCount = totalCountNode.asInt();
            int totalPages = (int) Math.ceil((double) totalCount / ROWS_PER_PAGE);

            List<FoodInfoVO> foods = new ArrayList<>();

            for (JsonNode item : items) {
                FoodInfoVO food = new FoodInfoVO();
                food.setDescKor(item.path("DESC_KOR").asText());
                food.setServingWt(item.path("SERVING_WT").asText());
                food.setNutrCont1(item.path("NUTR_CONT1").asText());
                food.setNutrCont2(item.path("NUTR_CONT2").asText());
                food.setNutrCont3(item.path("NUTR_CONT3").asText());
                food.setNutrCont4(item.path("NUTR_CONT4").asText());
                food.setNutrCont5(item.path("NUTR_CONT5").asText());
                food.setNutrCont6(item.path("NUTR_CONT6").asText());
                food.setNutrCont7(item.path("NUTR_CONT7").asText());
                food.setNutrCont8(item.path("NUTR_CONT8").asText());
                food.setNutrCont9(item.path("NUTR_CONT9").asText());
                food.setBgnYear(item.path("BGN_YEAR").asText());
                food.setAnimalPlant(item.path("ANIMAL_PLANT").asText());

                foods.add(food);
            }
            model.addAttribute("foods", foods);
            model.addAttribute("totalCount", totalCount);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("currentPage", page);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "데이터를 처리하는 중 에러가 발생했습니다.");
        }
        return "foodSearchResult";
    }
}

