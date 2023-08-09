package com.example.demo.level2;

import java.util.ArrayList;
import java.util.List;

public class FollowUp {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        int[] duplicated = {0,0};
        int[] different = {0,0};

        List<String> nonDupWords = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            if(nonDupWords.contains(words[i])){
                duplicated[0] = (i%n) + 1;
                duplicated[1] = (i/n) + 1;
                break;
            }
            nonDupWords.add(words[i]);
        }

        for(int i = 1; i < words.length; i++) {
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                different[0] = (i%n) + 1;
                different[1] = (i/n) + 1;
                break;
            }
        }
        // 중복과 끝말잇기 아닌 케이스가 두 개 다 존재할 경우
        if(different[0] > 0 && duplicated[0] > 0) {
            // 라운드 비교
            if(different[1] < duplicated[1]) {
                answer = different;
            }
            if(different[1] > duplicated[1]){
                answer = duplicated;
            }
            if(different[1] == duplicated[1]) {
                if(different[0] < duplicated[0]) {
                    answer = different;
                } else {
                    answer = duplicated;
                }
            }
        }
        // 탈락 케이스가 한 가지만 존재할 경우
        if(different[0] > 0) {
            answer = different;
        }
        if(duplicated[0] > 0) {
            answer = duplicated;
        }
        return answer;
    }
}
