package com.example.demo.level1;

public class Hamburger {
    public static void main(String[] args) {
        int[] ingrdnts = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        SolHam sol = new SolHam();
        System.out.println(sol.solution(ingrdnts));
    }
}

class SolHam {
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder ingredientString = new StringBuilder();
        // int 배열을 string으로 변환
        for (int i = 0; i < ingredient.length; i++) {
            ingredientString.append(ingredient[i]);
        }
        // string 길이가 4 이상일 때까지 반복
        while(ingredientString.length() >= 4 ) {
            System.out.println("재료 문자열: " + ingredientString);
            // 문자열이 1231 포함하면
            int firstHam = ingredientString.toString().indexOf("1231");
            System.out.println("햄버거 위치: " + firstHam);
            if(firstHam < 0) {
                return answer;
            }
            answer++;
            StringBuilder tmpString = new StringBuilder();
            tmpString.append(ingredientString.substring(0, firstHam));
            tmpString.append(ingredientString.substring(firstHam+4, ingredientString.length()));
            ingredientString = tmpString;
            System.out.println("새로운 재료 문자열: " + ingredientString);
        }
        return answer;
    }

}
