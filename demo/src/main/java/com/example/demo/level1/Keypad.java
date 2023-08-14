package com.example.demo.level1;

import java.util.HashMap;
import java.util.Map;

public class Keypad {
    public String solution(int[] numbers, String hand) {
        int[] leftThumb = {3,0};
        int[] rightThumb = {3,2};
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer[]> coordinate = new HashMap<>();
        coordinate.put(1, new Integer[]{0,0});
        coordinate.put(2, new Integer[]{0,1});
        coordinate.put(3, new Integer[]{0,2});
        coordinate.put(4, new Integer[]{1,0});
        coordinate.put(5, new Integer[]{1,1});
        coordinate.put(6, new Integer[]{1,2});
        coordinate.put(7, new Integer[]{2,0});
        coordinate.put(8, new Integer[]{2,1});
        coordinate.put(9, new Integer[]{2,2});
        coordinate.put(0, new Integer[]{3,1});

        for(int i = 0; i < numbers.length; i++) {
            int target = numbers[i];
            if(target == 2 || target == 5 || target == 8 || target == 0) {
                int[] targetXY = {coordinate.get(target)[0], coordinate.get(target)[1]};
                int targetToL = getDistance(targetXY, leftThumb);
                int targetToR = getDistance(targetXY, rightThumb);

                if(targetToL < targetToR) {
                    leftThumb = targetXY;
                    sb.append("L");
                    continue;
                }
                if(targetToR < targetToL) {
                    rightThumb = targetXY;
                    sb.append("R");
                    continue;
                }
                if(targetToL == targetToR) {
                    if(hand.equals("left")) {
                        leftThumb = targetXY;
                        sb.append("L");
                        continue;
                    } else {
                        rightThumb = targetXY;
                        sb.append("R");
                        continue;
                    }
                }
            }

            if(target == 1 || target == 4 || target == 7) {
                leftThumb = new int[]{coordinate.get(target)[0], coordinate.get(target)[1]};
                sb.append("L");
                continue;
            }

            if(target == 3 || target == 6 || target == 9) {
                rightThumb = new int[]{coordinate.get(target)[0], coordinate.get(target)[1]};
                sb.append("R");
            }
        }

        return sb.toString();
    }
    public int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
