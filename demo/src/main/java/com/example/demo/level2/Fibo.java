package com.example.demo.level2;

import java.util.ArrayList;
import java.util.List;

public class Fibo {
    public int solution(int n) {
        int answer = 0;
        List<Integer> fiboModular = new ArrayList<>();
        fiboModular.add(0, 0);
        fiboModular.add(1,1);
        for(int i = 2; i <= 100000; i++) {
            fiboModular.add(i, (fiboModular.get(i-1)%1234567 + fiboModular.get(i-2)%1234567)%1234567);
        }
        answer = fiboModular.get(n);
        return answer;
    }
}
