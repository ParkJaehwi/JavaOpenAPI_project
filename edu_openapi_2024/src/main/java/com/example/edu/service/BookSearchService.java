package com.example.edu.service;

import com.example.edu.model.FoodInfoVO;

import java.util.List;
import java.util.Map;

public interface BookSearchService {

    public List<FoodInfoVO> searchBookList (String uri, Map<String, String> requestHeaders) throws Exception;
}
