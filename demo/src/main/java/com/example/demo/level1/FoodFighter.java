package com.example.demo.level1;

public class FoodFighter {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder foods = new StringBuilder();
        for(int i = 1; i < food.length; i++) {
            int foodNum = food[i];
            if(foodNum%2 != 0) {
                foodNum--;
            }
            foods.append(String.valueOf(i).repeat(foodNum / 2));
        }
        foods.append("0");
        for(int i = food.length-1; i > 0; i--) {
            int foodNum = food[i];
            if(foodNum%2 != 0) {
                foodNum--;
            }
            foods.append(String.valueOf(i).repeat(foodNum / 2));
        }
        answer = foods.toString();
        return answer;
    }
}
