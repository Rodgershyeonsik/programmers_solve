package com.example.demo.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Tangerine {
    public static void main(String[] args) {
        Tangerine tan = new Tangerine();
        int[] tangerine = {1, 2};
        System.out.println(tan.solution(2,tangerine));
    }
    public int solution(int k, int[] tangerine) {
        int answer = 1;
        Arrays.sort(tangerine);

        List eachGyulNums = new ArrayList<Integer>();
        int eachGyul = 1;

        for(int i = 0; i < tangerine.length - 1; i++) {

            int a = tangerine[i];
            int b = tangerine[i + 1];

            if(a == b) {
                eachGyul++;

                if(i == tangerine.length - 2) {
                    eachGyulNums.add(eachGyul);
                }
            } else if(a < b && i == tangerine.length - 2) {

                eachGyulNums.add(eachGyul);
                eachGyulNums.add(eachGyul);

            } else {

                eachGyulNums.add(eachGyul);
                eachGyul = 1;

            }
        }
        eachGyulNums.sort(Comparator.reverseOrder());

        int gyulBox = 0;
        for(int i = 0; i < eachGyulNums.size(); i++) {
            gyulBox += (int)eachGyulNums.get(i);
            if(gyulBox >= k) {
                answer += i;
                break;
            }
        }
        return answer;
    }
}
