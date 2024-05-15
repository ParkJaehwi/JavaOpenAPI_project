//package com.example.edu.controller;//package com.example.edu.controller;
//
//import com.example.edu.model.FoodInfoVO;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class FoodSearchController {
//
//    @RequestMapping(value = "/food")
//    public String bookSearchPage() throws Exception {
//        return "food";
//    }
//
//    @RequestMapping(value = "/foodsearch")
////    public String bookSearchList(String keyword, Model model) {
////        String url = "https://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1?ServiceKey=DsUAduFiNXosF4vwy50AMcCRk9sYGUOEuVAXTab4UL%2BxhoqapEvU33LLFozTQYcRSVmIkGqX4Xke5XheHQIAwg%3D%3D&numOfRows=20&type=json&desc_kor=" + keyword;
////
////        RestTemplate restTemplate = new RestTemplate();
////        String result = restTemplate.getForObject(url, String.class);
////        System.out.println(result);
//
//        public String bookSearchList(String keyword, Integer page, Model model) {
//            if (page == null || page < 1) {
//                page = 1; // 기본 페이지 번호를 1로 설정
//            }
//
//            String url = "https://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1?ServiceKey=DsUAduFiNXosF4vwy50AMcCRk9sYGUOEuVAXTab4UL%2BxhoqapEvU33LLFozTQYcRSVmIkGqX4Xke5XheHQIAwg%3D%3D&numOfRows=20&pageNo=" + page + "&type=json&desc_kor=" + keyword;
//            RestTemplate restTemplate = new RestTemplate();
//            String result = restTemplate.getForObject(url, String.class);
//            System.out.println(result);
//
//        try {
//            // 응답이 XML 형식인지 확인
//            if (result.trim().startsWith("<")) {
//                model.addAttribute("errorMessage", "API 서버 에러입니다. 잠시 후 다시 이용해주세요.");
//
//                System.out.println("API 서버 에러입니다. 잠시 후 다시 이용해주세요.");
//                return "foodSearchResult";
//            }
//
//
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode root = mapper.readTree(result);
//            JsonNode items = root.path("body").path("items");
//            JsonNode totalCount = root.path("body").path("totalCount");
//
//
//            List<FoodInfoVO> foods = new ArrayList<>();
//            for (JsonNode item : items) {
//                FoodInfoVO food = new FoodInfoVO();
//                food.setDescKor(item.path("DESC_KOR").asText());
//                food.setServingWt(item.path("SERVING_WT").asText());
//                food.setNutrCont1(item.path("NUTR_CONT1").asText());
//                food.setNutrCont2(item.path("NUTR_CONT2").asText());
//                food.setNutrCont3(item.path("NUTR_CONT3").asText());
//                food.setNutrCont4(item.path("NUTR_CONT4").asText());
//                food.setNutrCont5(item.path("NUTR_CONT5").asText());
//                food.setNutrCont6(item.path("NUTR_CONT6").asText());
//                food.setNutrCont7(item.path("NUTR_CONT7").asText());
//                food.setNutrCont8(item.path("NUTR_CONT8").asText());
//                food.setNutrCont9(item.path("NUTR_CONT9").asText());
//                food.setBgnYear(item.path("BGN_YEAR").asText());
//                food.setAnimalPlant(item.path("ANIMAL_PLANT").asText());
//
//
//
//                foods.add(food);
//            }
//
//            model.addAttribute("foods", foods);
//            model.addAttribute("keyword", keyword);
//            model.addAttribute("totalCount", totalCount);
//            System.out.println("토탈: " + totalCount);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "foodSearchResult";
//    }
//}

////package com.example.edu.controller;
////
////import com.example.edu.model.FoodInfoVO;
////import com.fasterxml.jackson.databind.JsonNode;
////import com.fasterxml.jackson.databind.ObjectMapper;
////import org.springframework.stereotype.Controller;
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.client.RestTemplate;
////
////import java.util.ArrayList;
////import java.util.List;
////
////@Controller
////public class FoodSearchController {
////
////    @RequestMapping(value = "/food")
////    public String bookSearchPage() throws Exception {
////        return "food";
////    }
////
////    @RequestMapping(value = "/foodsearch")
////    public String bookSearchList(String keyword, Model model) {
////        String url = "https://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1?ServiceKey=DsUAduFiNXosF4vwy50AMcCRk9sYGUOEuVAXTab4UL%2BxhoqapEvU33LLFozTQYcRSVmIkGqX4Xke5XheHQIAwg%3D%3D&numOfRows=20&pageNo=1&type=json&desc_kor=" + keyword;
////
////        RestTemplate restTemplate = new RestTemplate();
////        String result = restTemplate.getForObject(url, String.class);
////        System.out.println(result);
////
////        try {
////            // 응답이 XML 형식인지 확인
////            if (result.trim().startsWith("<")) {
////                model.addAttribute("errorMessage", "API 서버 에러입니다. 잠시 후 다시 이용해주세요.");
////                System.out.println("API 서버 에러입니다. 잠시 후 다시 이용해주세요.");
////                return "foodSearchResult";
////            }
////
////            ObjectMapper mapper = new ObjectMapper();
////            JsonNode root = mapper.readTree(result);
////            JsonNode items = root.path("body").path("items");
////            JsonNode totalCountNode = root.path("body").path("totalCount");
////
////            int totalCount = totalCountNode.asInt();
////            int totalPages = (int) Math.ceil((double) totalCount / 20);
////
////            List<FoodInfoVO> foods = new ArrayList<>();
////            for (JsonNode item : items) {
////                FoodInfoVO food = new FoodInfoVO();
////                food.setDescKor(item.path("DESC_KOR").asText());
////                food.setServingWt(item.path("SERVING_WT").asText());
////                food.setNutrCont1(item.path("NUTR_CONT1").asText());
////                food.setNutrCont2(item.path("NUTR_CONT2").asText());
////                food.setNutrCont3(item.path("NUTR_CONT3").asText());
////                food.setNutrCont4(item.path("NUTR_CONT4").asText());
////                food.setNutrCont5(item.path("NUTR_CONT5").asText());
////                food.setNutrCont6(item.path("NUTR_CONT6").asText());
////                food.setNutrCont7(item.path("NUTR_CONT7").asText());
////                food.setNutrCont8(item.path("NUTR_CONT8").asText());
////                food.setNutrCont9(item.path("NUTR_CONT9").asText());
////                food.setBgnYear(item.path("BGN_YEAR").asText());
////                food.setAnimalPlant(item.path("ANIMAL_PLANT").asText());
////
////                foods.add(food);
////            }
////
////            model.addAttribute("foods", foods);
////            model.addAttribute("totalCount", totalCount);
////            model.addAttribute("totalPages", totalPages);
////            System.out.println("총 검색 결과: " + totalCount);
////            System.out.println("총 페이지 수: " + totalPages);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////
////        return "foodSearchResult";
////    }
////}
//package com.example.edu.controller;
//
//import com.example.edu.model.FoodInfoVO;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class FoodSearchController {
//
//    private static final int ROWS_PER_PAGE = 20; // 한 페이지당 표시할 항목 수
//
//    @RequestMapping(value = "/food")
//    public String bookSearchPage() throws Exception {
//        return "food";
//    }
//
//    @RequestMapping(value = "/foodsearch")
//    public String bookSearchList(String keyword, Integer page, Model model) {
//        if (page == null || page < 1) {
//            page = 1; // 기본 페이지 번호를 1로 설정
//        }
//
//        String url = "https://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1?ServiceKey=DsUAduFiNXosF4vwy50AMcCRk9sYGUOEuVAXTab4UL%2BxhoqapEvU33LLFozTQYcRSVmIkGqX4Xke5XheHQIAwg%3D%3D&numOfRows=20&pageNo=" + page + "&type=json&desc_kor=" + keyword;
//
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(url, String.class);
//        System.out.println(result);
//
//        try {
//            // 응답이 XML 형식인지 확인
//            if (result.trim().startsWith("<")) {
//                model.addAttribute("errorMessage", "API 서버 에러입니다. 잠시 후 다시 이용해주세요.");
//
//                System.out.println("API 서버 에러입니다. 잠시 후 다시 이용해주세요.");
//                return "foodSearchResult";
//            }
//
//
//            try {
//                ObjectMapper mapper = new ObjectMapper();
//                JsonNode root = mapper.readTree(result);
//                JsonNode items = root.path("body").path("items");
//                JsonNode totalCountNode = root.path("body").path("totalCount");
//
//                int totalCount = totalCountNode.asInt();
//                int totalPages = (int) Math.ceil((double) totalCount / ROWS_PER_PAGE);
//
//                List<FoodInfoVO> foods = new ArrayList<>();
//                for (JsonNode item : items) {
//                    FoodInfoVO food = new FoodInfoVO();
//                    food.setDescKor(item.path("DESC_KOR").asText());
//                    food.setServingWt(item.path("SERVING_WT").asText());
//                    food.setNutrCont1(item.path("NUTR_CONT1").asText());
//                    food.setNutrCont2(item.path("NUTR_CONT2").asText());
//                    food.setNutrCont3(item.path("NUTR_CONT3").asText());
//                    food.setNutrCont4(item.path("NUTR_CONT4").asText());
//                    food.setNutrCont5(item.path("NUTR_CONT5").asText());
//                    food.setNutrCont6(item.path("NUTR_CONT6").asText());
//                    food.setNutrCont7(item.path("NUTR_CONT7").asText());
//                    food.setNutrCont8(item.path("NUTR_CONT8").asText());
//                    food.setNutrCont9(item.path("NUTR_CONT9").asText());
//                    food.setBgnYear(item.path("BGN_YEAR").asText());
//                    food.setAnimalPlant(item.path("ANIMAL_PLANT").asText());
//
//                    foods.add(food);
//                }
//
//                model.addAttribute("foods", foods);
//                model.addAttribute("totalCount", totalCount);
//                model.addAttribute("totalPages", totalPages);
//                model.addAttribute("currentPage", page); // 현재 페이지 번호를 모델에 추가
//
//                System.out.println("총 검색 결과: " + totalCount);
//                System.out.println("총 페이지 수: " + totalPages);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            return "foodSearchResult";
//        }
//    }
//}

package com.example.edu.controller;

import com.example.edu.model.FoodInfoVO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FoodSearchController {

    private static final int ROWS_PER_PAGE = 20; // 한 페이지당 표시할 항목 수

    @RequestMapping(value = "/food")
    public String bookSearchPage() throws Exception {
        return "food";
    }

    @RequestMapping(value = "/foodsearch")
    public String bookSearchList(String keyword, Integer page, Model model) {
        if (page == null || page < 1) {
            page = 1; // 기본 페이지 번호를 1로 설정
        }

        String url = "https://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1?ServiceKey=DsUAduFiNXosF4vwy50AMcCRk9sYGUOEuVAXTab4UL%2BxhoqapEvU33LLFozTQYcRSVmIkGqX4Xke5XheHQIAwg%3D%3D&numOfRows=20&pageNo=" + page + "&type=json&desc_kor=" + keyword;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);

        try {
            // 응답이 XML 형식인지 확인
            if (result.trim().startsWith("<")) {
                model.addAttribute("errorMessage", "API 서버 에러입니다. 잠시 후 다시 이용해주세요.");

                System.out.println("API 서버 에러입니다. 잠시 후 다시 이용해주세요.");
                return "foodSearchResult";
            }


            try {
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
                model.addAttribute("currentPage", page); // 현재 페이지 번호를 모델에 추가

                System.out.println("총 검색 결과: " + totalCount);
                System.out.println("총 페이지 수: " + totalPages);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "foodSearchResult";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "foodSearchResult";
    }
}