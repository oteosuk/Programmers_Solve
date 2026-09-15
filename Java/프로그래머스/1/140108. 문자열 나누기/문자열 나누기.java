class Solution {
    public int solution(String s) {
        int answer = 0;
        int sameCnt = 0, diffCnt = 0;
        char first = 0;

        for (char c : s.toCharArray()) {
            if (sameCnt == 0) {
                first = c;
                sameCnt++;
            } else if (c == first) {
                sameCnt++;
            } else {
                diffCnt++;
            }

            if (sameCnt == diffCnt) {
                answer++;
                sameCnt = 0; diffCnt = 0;
            }
        }
        
        if (sameCnt > 0) answer++;   // 남은 조각
        return answer;
    }
}