package com.example.edu.controller;

import java.util.List;

public class FoodData {
    private Body body;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public static class Body {
        private List<FoodItem> items;

        public List<FoodItem> getItems() {
            return items;
        }

        public void setItems(List<FoodItem> items) {
            this.items = items;
        }
    }

    public static class FoodItem {
        private String DESC_KOR;
        private String SERVING_WT;
        private String NUTR_CONT1;
        private String NUTR_CONT2;
        private String NUTR_CONT3;
        private String NUTR_CONT4;
        private String NUTR_CONT5;
        private String NUTR_CONT6;

        // Getters and setters...
    }
}
