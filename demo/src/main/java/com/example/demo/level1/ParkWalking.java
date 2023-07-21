package com.example.demo.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ParkWalking {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};

        ParkWalkingSov sov = new ParkWalkingSov();
        System.out.println(Arrays.toString(sov.solution(park, routes)));
    }
}

class ParkWalkingSov {
    public int[] solution(String[] park, String[] routes) {
        // 공원 크기 구하기
        int H = park.length; // 공원 높이: park의 길이
        int W = park[0].length(); // 공원 너비: part의 요소 길이
        Set<String> obstacleInfo = new HashSet<>(); // 장애물 좌표 저장할 변수
        int[] currentLocation = {0,0}; // 현재 위치

        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                // 시작점 좌표 구하기
                if(park[h].charAt(w) == 'S') {
                    currentLocation = new int[]{h, w};
                }
                if(park[h].charAt(w) == 'X') {
                    obstacleInfo.add(h + " " + w);
                }
            }
        }

        for (int h = 0; h < routes.length; h++) {
            String op = routes[h].split(" ")[0];
            int n = Integer.parseInt(routes[h].split(" ")[1]);
            int[] tmpLocation = {currentLocation[0], currentLocation[1]}; // 임시 이동경로 저장

            for (int j = 0; j < n; j++) {
                if(op.equals("N")) {
                    tmpLocation[0]-- ;
                }
                if(op.equals("S")) {
                    tmpLocation[0]++;
                }
                if(op.equals("W")) {
                    tmpLocation[1]--;
                }
                if(op.equals("E")) {
                    tmpLocation[1]++;
                }
                String now = tmpLocation[0] + " " + tmpLocation[1];

                if(obstacleInfo.contains(now)) {
                    tmpLocation[0] = currentLocation[0];
                    tmpLocation[1] = currentLocation[1]; // 원상복구
                    break;
                }
            }
            // 이동 끝나고 공원 넘어가나 확인
            if(tmpLocation[0] > H - 1 || tmpLocation[0] < 0 || tmpLocation[1] > W - 1 || tmpLocation[1] < 0) {
                continue;
            }
            currentLocation[0] = tmpLocation[0];
            currentLocation[1] = tmpLocation[1];
        }
        return currentLocation;
    }
}