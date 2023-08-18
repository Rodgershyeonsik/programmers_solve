package com.example.demo.level1;

public class Knights {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            int weapon = 0;
            for(int j = 1; j*j<= i; j++) {
                if(j*j == i) {
                    weapon++;
                } else if(i%j == 0) {
                    weapon += 2;
                }
            }
            if(weapon > limit) {
                answer += power;
            } else {
                answer += weapon;
            }
        }
        return answer;
    }
}
