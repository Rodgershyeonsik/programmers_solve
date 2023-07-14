package com.example.demo.level2;

import java.util.HashMap;
import java.util.Map;

public class KakaoMbti {
    public static void main(String[] args) {

    }
}

class Solution{
    public String solution(String[] survey, int[] choices) {
        // survey = ["RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA" 중 1개]
        // survey.length == choices.length
        String answer = "";
        Map<Character, Integer> scores = new HashMap<>();
        scores.put('R', 0);
        scores.put('T', 0);
        scores.put('F', 0);
        scores.put('C', 0);
        scores.put('M', 0);
        scores.put('J', 0);
        scores.put('A', 0);
        scores.put('N', 0);
        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            Character negativeCategory = survey[i].charAt(0);
            Character positiveCategory = survey[i].charAt(1);
            // 4 == 0
            if(choice == 0) {
                continue;
            }
            // 앞 캐릭이 1, 2, 3일 때 3, 2, 1점
            if(choice < 4) {
                Integer score = 0;
                if(choice == 1) {
                    score = 3;
                }
                if(choice == 2) {
                    score = 2;
                }
                if(choice == 3) {
                    score = 1;
                }
                scores.replace(negativeCategory, scores.get(negativeCategory) + score);
            }
            // 뒷 캐릭이 5, 6, 7일 때 1, 2, 3점
            if(choice > 4) {
                Integer score = 0;
                if(choice == 7) {
                    score = 3;
                }
                if(choice == 6) {
                    score = 2;
                }
                if(choice == 5) {
                    score = 1;
                }
                scores.replace(positiveCategory, scores.get(positiveCategory) + score);
            }
        }
        if(scores.get('R') < scores.get('T')) {
            answer += 'T';
        } else {
            answer += 'R';
        }
        if(scores.get('C') < scores.get('F')) {
            answer += 'F';
        } else {
            answer += 'C';
        }
        if(scores.get('J') < scores.get('M')) {
            answer += 'M';
        } else {
            answer += 'J';
        }
        if(scores.get('A') < scores.get('N')) {
            answer += 'N';
        } else {
            answer += 'A';
        }
        return answer;
    }
}
