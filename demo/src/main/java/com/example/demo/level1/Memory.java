package com.example.demo.level1;

import java.util.HashMap;
import java.util.Map;

public class Memory {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> nameAndYearningMap = new HashMap<>();
        for(int i = 0; i < name.length; i++) {
            nameAndYearningMap.put(name[i], yearning[i]);
        }
        for(int i = 0; i < photo.length; i++) {
            int tmpScore = 0;
            for(int j = 0; j < photo[i].length; j++) {
                Integer yearningOfJ = nameAndYearningMap.get(photo[i][j]);
                if(yearningOfJ != null){
                    tmpScore += yearningOfJ;
                }
            }
            answer[i] = tmpScore;
        }
        return answer;
    }
}
