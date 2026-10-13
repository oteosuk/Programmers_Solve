import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 중복 제거
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        // 신고당한 사람별 횟수
        Map<String, Integer> reportCount = new HashMap<>();
        
        // 각 신고자가 신고한 사람들
        Map<String, Set<String>> userReports = new HashMap<>();
        
        for (String r : reportSet) {
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String reported = parts[1];
            
            reportCount.put(reported, reportCount.getOrDefault(reported, 0) + 1);
            
            userReports.putIfAbsent(reporter, new HashSet<>());
            userReports.get(reporter).add(reported);
        }
        
        // 정지 대상
        Set<String> banned = new HashSet<>();
        for (String user : reportCount.keySet()) {
            if (reportCount.get(user) >= k) {
                banned.add(user);
            }
        }
        
        // 결과 계산
        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            if (userReports.containsKey(id_list[i])) {
                for (String reported : userReports.get(id_list[i])) {
                    if (banned.contains(reported)) {
                        result[i]++;
                    }
                }
            }
        }
        
        return result;
    }
}