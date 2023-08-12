package com.example.demo.level1;

public class Kim {
    public String solution(String[] seoul) {
        int indexOfKim = 0;
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                indexOfKim = i;
                break;
            }
        }
        return "김서방은 " + indexOfKim + "에 있다";
    }
}
