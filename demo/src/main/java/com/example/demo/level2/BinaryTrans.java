package com.example.demo.level2;

public class BinaryTrans {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String target = s;
        int totalTrns = 0;
        int totalZero = 0;

        while(true){
            if(target.equals("1")) {
                break;
            }
            int numOfZero = 0;
            for(int i = 0; i < target.length(); i++) {
                if(target.charAt(i)=='0') {
                    numOfZero++;
                }
            }
            totalTrns++;
            totalZero += numOfZero;

            target = Integer.toBinaryString(target.length() - numOfZero);
        }

        answer[0] = totalTrns;
        answer[1] = totalZero;

        return answer;
    }
}
