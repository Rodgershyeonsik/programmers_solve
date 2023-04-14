package com.example.demo.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickTwo {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        List<Integer> results = new ArrayList<>();

        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i+1; j < numbers.length; j++ ) {
                results.add(numbers[i] + numbers[j]);
            }
        }
        List<Integer> newResults = new ArrayList<>();

        for(Integer i : results) {
            if(!newResults.contains(i)){
                newResults.add(i);
            }
        }

        answer = new int[newResults.size()];
        for(int i = 0; i < newResults.size(); i++) {
            answer[i] = newResults.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}
