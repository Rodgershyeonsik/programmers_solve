package com.example.demo.level1;

public class Collatz {
    public static void main(String[] args) {
        CollatzSol cSol = new CollatzSol();
        System.out.println(cSol.solution(626331));
    }
}

class CollatzSol{
    public int solution(int num) {
        int answer = 0;

        if(num == 1) {
            return answer;
        }

        while(true) {
            if(num % 2 == 1) {
                num = num*3 + 1;
            } else {
                num = num/2;
            }
            answer++;

            if(num == 1) {
                break;
            }

            if(answer == 500) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}
