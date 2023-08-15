package com.example.demo.level2;

public class Parentheses {
    boolean solution(String s) {
        if(s.length()%2 > 0) {
            return false;
        }
        if(s.charAt(0) == ')' || s.charAt(s.length()-1) == '(') {
            return false;
        }

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                cnt += 1;
            } else {
                cnt -= 1;
            }
            if(cnt < 0) {
                return false;
            }
        }
        if(cnt == 0) {
            return true;
        } else {
            return false;
        }
    }
}
