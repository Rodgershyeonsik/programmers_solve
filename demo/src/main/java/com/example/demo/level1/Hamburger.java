package com.example.demo.level1;

import java.util.Stack;

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
        Stack<Integer> ingredientStack = new Stack<>();
        for(int i = 0; i < ingredient.length; i++) {
            ingredientStack.push(ingredient[i]);

            if(ingredientStack.size()>=4) {
                int topPosition = ingredientStack.search(1);
                int topIndex = ingredientStack.size() - topPosition;
                if(topPosition > 0 && (topPosition + 3) <= ingredientStack.size()) {
                    int meatIndex = topIndex - 1;
                    int vegeIndex = topIndex - 2;
                    int bottomIndex = topIndex - 3;

                    if(ingredientStack.get(meatIndex) == 3 && ingredientStack.get(vegeIndex) == 2
                    && ingredientStack.get(bottomIndex) == 1) {
                        answer++;
                        ingredientStack.remove(topIndex);
                        ingredientStack.remove(meatIndex);
                        ingredientStack.remove(vegeIndex);
                        ingredientStack.remove(bottomIndex);
                    }
                }
            }
        }
        return answer;
    }

}
