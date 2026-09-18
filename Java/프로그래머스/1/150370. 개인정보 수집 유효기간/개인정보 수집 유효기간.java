import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayTotal = getTotal(today);

        // 약관 파싱
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] parts = term.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]));
        }

        // 만료일 계산 + 비교
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            int expire = getTotal(parts[0]) + termMap.get(parts[1]) * 28;

            if (expire <= todayTotal) answer.add(i + 1);
        }
        //int[] result = new int[answer.size()];
        //for (int i = 0; i < answer.size(); i++) {
            //result[i] = answer.get(i);   // 여기서 언박싱 자동 발생
        //}
        //return result;
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }

    private int getTotal(String date) {
        String[] p = date.split("\\.");
        int y = Integer.parseInt(p[0]);
        int m = Integer.parseInt(p[1]);
        int d = Integer.parseInt(p[2]);
        return y * 12 * 28 + (m - 1) * 28 + d;
    }
}