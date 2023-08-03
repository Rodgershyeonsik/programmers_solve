package com.example.demo.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wallpapers {

    class Solution {
        public int[] solution(String[] wallpaper) {
            // 파일 위치 정보 저장
            List<int[]> fileLocations = new ArrayList<>();

            for(int i = 0; i < wallpaper.length; i++) {
                String[] tmpArr = wallpaper[i].split("");

                for(int j = 0; j < tmpArr.length; j++) {
                    if(tmpArr[j].equals("#")) {
                        int[] fileLocation = {i,j};
                        fileLocations.add(fileLocation);
                    }
                }
            }
            // 각 파일의 세로좌표, 가로좌표 값을 담을 배열 만들기.
            int[] a = new int[fileLocations.size()];
            int[] b = new int[fileLocations.size()];

            for(int i = 0; i < fileLocations.size(); i++) {
                int[] target = fileLocations.get(i);
                a[i] = target[0];
                b[i] = target[1];
            }
            Arrays.sort(a);
            Arrays.sort(b);

            int[] answer = {a[0], b[0], a[a.length-1]+1, b[b.length-1]+1};
            return answer;
        }
    }
}
