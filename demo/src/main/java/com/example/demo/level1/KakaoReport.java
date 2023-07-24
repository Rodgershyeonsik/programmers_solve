package com.example.demo.level1;

import java.util.*;

public class KakaoReport {
    public static void main(String[] args) {
        Solve sol = new Solve();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        System.out.println(Arrays.toString(sol.solution(id_list, report, 2)));
    }
}

class Solve{
    public int[] solution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> userReportInfo = new HashMap<>(); // 유저별 신고내역 저장
        Map<String, Integer> reportedUserInfoMap = new HashMap<>(); // 유저가 신고당한 내역 저장
        Set<String> reportToSet = new HashSet<>(Arrays.asList(report)); // 중복 제거를 위해 report를 set으로 변환

        for (String s : reportToSet) {
            // report 신고유저, 신고당한 유저 분리
            String[] reportSplit = s.split(" ");
            String user = reportSplit[0];
            String reportedUser = reportSplit[1];

            // 기존에 신고 내역이 있으면 기존 신고 내역 set에 신고한 유저 이름 추가
            if (userReportInfo.containsKey(user)) {
                Set<String> reportSet = userReportInfo.get(user);
                reportSet.add(reportedUser);
                userReportInfo.replace(user, reportSet);
            } else {
                // 신고 내역에 없으면 신고 내역 set 만들고 map 추가
                Set<String> reportSet = new HashSet<>();
                reportSet.add(reportedUser);
                userReportInfo.put(user, reportSet);
            }
            // 신고 당한 적 있는 유저면 기존 신고 내역에 1 더하기
            if (reportedUserInfoMap.containsKey(reportedUser)) {
                reportedUserInfoMap.replace(reportedUser, reportedUserInfoMap.get(reportedUser) + 1);
            } else {
                // 신고 당한 적 없으면 신고횟수 1회로 지정
                reportedUserInfoMap.put(reportedUser, 1);
            }
        }
        // 정지당한 유저 정보를 저장할 set
        Set<String> suspendedUser = new HashSet<>();
        // 신고 횟수가 k 이상인 유저 골라내기
        for ( Map.Entry<String, Integer> entry: reportedUserInfoMap.entrySet()) {
            String user = entry.getKey();
            Integer reportedNum = entry.getValue();
            if(reportedNum >= k) {
                suspendedUser.add(user);
            }
        }
        // 각 유저의 신고 내역에 정지당한 유저를 신고한 내역이 있는지 확인
        for (int i = 0; i < id_list.length; i++) {
            Set<String> reportInfo = userReportInfo.get(id_list[i]);
            int resultMailNum = 0;
            for (String user : suspendedUser) {
                if(reportInfo != null && reportInfo.contains(user)) {
                    resultMailNum++;
                }
            }
            answer[i] = resultMailNum;
        }
        return answer;
    }
}
