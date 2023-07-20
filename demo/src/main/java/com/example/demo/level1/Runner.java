package com.example.demo.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(players, callings)));
    }
}

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer =  new String[players.length];
        Map<String, Integer> rankingMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            rankingMap.put(players[i], i);
        }
        for (int i = 0; i < callings.length; i++) {
            String callingPlayer = callings[i];
            System.out.println("callingPlayer: " + callingPlayer);
            Integer newRank = rankingMap.get(callingPlayer) - 1;
            System.out.println("newRank: " + newRank);
            String passedPlayer = players[newRank];
            System.out.println("passedPlayer: " + passedPlayer);

            rankingMap.replace(callingPlayer, newRank);
            rankingMap.replace(passedPlayer, newRank + 1);
            players[newRank] = callingPlayer;
            players[newRank + 1] = passedPlayer;
            System.out.println("now rank: " + callingPlayer + ", " + rankingMap.get(callingPlayer));
            System.out.println("now rank: " + passedPlayer + ", " + rankingMap.get(passedPlayer));
        }

        for (int i = 0; i < players.length; i++) {
            answer[rankingMap.get(players[i])] = players[i];
        }
        return answer;
    }
}
