package com.example.demo.level1;

public class NumberWord {
    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }
    public static int solution(String s) {
        int answer = 0;
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < words.length; i++) {
            if(s.contains(words[i])) {
                s = s.replace(words[i], Integer.toString(i));
            }
        }
        answer = Integer.parseInt(s);

        return answer;
    }
}
