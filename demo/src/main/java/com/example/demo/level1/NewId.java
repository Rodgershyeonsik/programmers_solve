package com.example.demo.level1;

public class NewId {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^a-zA-Z0-9_\\-.]","");
        answer = answer.replaceAll("\\.{2,}", ".");

        if(answer.length() > 0 && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }
        if(answer.length() > 0 && answer.charAt(answer.length()-1) == '.') {
            answer = answer.substring(0,answer.length()-1);
        }

        if(answer.isEmpty()) {
            answer = "a";
        }

        if(answer.length() >= 16) {
            answer = answer.substring(0,15);
            if(answer.charAt(14) == '.') {
                answer = answer.substring(0,14);
            }
        }

        if(answer.length() < 3) {
            char lastChar = answer.charAt(answer.length()-1);
            while(answer.length() < 3) {
                answer = answer + lastChar;
            }
        }
        return answer;
    }
}
