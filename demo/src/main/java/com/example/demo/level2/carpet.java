package com.example.demo.level2;

public class carpet {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int l = 3;
        int w = total/l;
        while(true) {
            int calB = w*2 + l*2 - 4;
            int calY = (w-2)*(l-2);
            if(calB == brown && calY == yellow){
                break;
            } else {
                l++;
                w = total/l;
            }
        }
        int[] answer = {w, l};

        return answer;
    }
}
