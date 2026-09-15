import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] uniformCnt = new int[n];
        Arrays.fill(uniformCnt, 1);
        for (int i : lost) uniformCnt[i - 1]--;
        for (int i : reserve) uniformCnt[i - 1]++;
        

         // 왼쪽부터 순회하기때문에 왼쪽부터 나눠줘야함 (오른쪽부터나눠주면 안되는 반례 ex0 2 0 2 )
        for (int i = 0; i < n; i++) {
            if (uniformCnt[i] != 2) continue;
            if (i > 0 && uniformCnt[i - 1] == 0) {
                uniformCnt[i - 1]++; uniformCnt[i]--;
            } else if (i < n - 1 && uniformCnt[i + 1] == 0) {
                uniformCnt[i + 1]++; uniformCnt[i]--;
            }
        }

        
        int answer = 0;
        for (int count : uniformCnt) if (count > 0) answer++;
        return answer;
    }
}