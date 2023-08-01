package com.example.demo.level1;

public class SmallStr {
    public int solution(String t, String p) {
        int answer = 0;
        long ptoInt = Long.parseLong(p);

        for(int i = 0; i <= t.length() - p.length(); i++) {
            long partOfT = Long.parseLong(t.substring(i, i + p.length()));
            if(partOfT <= ptoInt) {
                answer++;
            }
        }
        return answer;
    }
}
