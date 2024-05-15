package com.example.edu.service.impl;

import java.util.List;
import java.util.Map;

import com.example.edu.adapter.BookInfoSearchInterface;
import com.example.edu.model.FoodInfoVO;
import com.example.edu.model.FoodSearchResultVO;
import com.example.edu.service.BookSearchService;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("bookSearchService")
public class BookSearchServiceImpl implements BookSearchService {
	
	BookInfoSearchInterface bookSearchInterface = new BookInfoSearchInterface();
	
	@Override
	public List<FoodInfoVO> searchBookList (String url, Map<String, String> requestHeaders) throws Exception {
		
		String responseBody =  bookSearchInterface.getBookInfo(url, requestHeaders);
        ObjectMapper mapper = new ObjectMapper();
        FoodSearchResultVO resultVO  = null;
        
        try {
        	
        	resultVO = mapper.readValue(responseBody, FoodSearchResultVO.class);

        } catch (JsonMappingException e) {
        	throw new Exception("JSON 에러 : " + e);
        } catch (JsonProcessingException e) {
        	throw new Exception("JSON 에러 : " + e);
        }
        
        List<FoodInfoVO> books =resultVO.getItems();
            
        
        for (int i=0 ; i < books.size(); i++) {
           	FoodInfoVO bookInfo = books.get(i);
           	System.out.println(i+" ==> "+bookInfo.getTitle());
        }
       
		return  books;
		
	}

}
