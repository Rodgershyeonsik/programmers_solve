package com.example.demo.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Privacy {
    public static void main(String[] args) {
        Privacy p = new Privacy();

        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        p.solution("2022.05.19",terms, privacies);
    }
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 오늘 날짜로 파기할 개인정보 번호 구하기
        int[] answer = {};
        Map<String, Integer> termsMap = new HashMap<>();
        List<Integer> toBeDestroyed = new ArrayList<>();
        // 약관 잘라서 맵에다 넣기. key == 약관 종류, value == 유효기간
        for(String t : terms){
            String[] termsArr = t.split(" ");
            termsMap.put(termsArr[0], Integer.valueOf(termsArr[1]));
        }
        // 파기할 정보 구하려면...
        // privacies 날짜에 약관 종류별 개인정보 기간 더해서 파기 기간 구하기.
        for(int i = 0; i < privacies.length ; i++) {
            String[] privacyDateAndType = privacies[i].split(" ");
            String[] date = privacyDateAndType[0].split("\\.");
            int exp = termsMap.get(privacyDateAndType[1]);

            int expYear = Integer.parseInt(date[0]);
            int expMonth = Integer.parseInt(date[1]);
            int expDate = Integer.parseInt(date[2]);

            if(exp % 12 == 0) {
                expYear += exp / 12;
            } else {
                expYear += exp / 12;
                expMonth += exp % 12;
            }

            if(expMonth > 12) {
                expYear += 1;
                expMonth -= 12;
            }

            String[] todayArr = today.split("\\.");
            int todayYear = Integer.parseInt(todayArr[0]);
            int todayMonth = Integer.parseInt(todayArr[1]);
            int todayDate = Integer.parseInt(todayArr[2]);

            // today와 비교해서 파기 기한 지난 애들 고르기.
            System.out.println(i+ "번 째 파기일은? " + expYear + expMonth + expDate);
            if(todayYear > expYear) {
                toBeDestroyed.add(i + 1);
            } else if(todayYear == expYear && todayMonth > expMonth) {
                toBeDestroyed.add(i + 1);
            } else if(todayYear == expYear && todayMonth == expMonth && todayDate >= expDate) {
                toBeDestroyed.add(i + 1);
            }
        }
        int[] tmp = new int[toBeDestroyed.size()];

        for(int i = 0; i < toBeDestroyed.size(); i++) {
            tmp[i] = toBeDestroyed.get(i);
        }
        answer = tmp;
        return answer;
    }
}
