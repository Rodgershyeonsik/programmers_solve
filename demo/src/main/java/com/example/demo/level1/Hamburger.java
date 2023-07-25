package com.example.demo.level1;

import java.util.ArrayList;
import java.util.List;

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
        // 빵:1 야채:2 고기:3
        // 배열을 검사해서 1231 순서면 햄버거 포장
        // 일단 가장 먼저 나오는 1을 찾는다.
        List<Integer> ingredientList = new ArrayList<>();
        for (int ingre: ingredient) {
            ingredientList.add(ingre);
        }
        int firstBunIdx = ingredientList.indexOf(1);
        while (ingredientList.size() >= 4) {
            // 네번째 빵이 나올 위치가 ingredient.length - 1보다 크면 햄버거 포장 못함.
            if(firstBunIdx + 3 > ingredientList.size() - 1) {
                return answer;
            }
            if(ingredientList.get(firstBunIdx+1).equals(2) &&
                    ingredientList.get(firstBunIdx+2).equals(3) &&
                    ingredientList.get(firstBunIdx+3).equals(1)) {
                answer++;
                // 햄버거 포장한 재료 치우기
                ingredientList.remove(firstBunIdx);
                ingredientList.remove(firstBunIdx);
                ingredientList.remove(firstBunIdx);
                ingredientList.remove(firstBunIdx);
                // 빵 위치 다시 찾기
                firstBunIdx = ingredientList.indexOf(1);
            } else {
                firstBunIdx++;
            }
        }
        return answer;
    }

}
