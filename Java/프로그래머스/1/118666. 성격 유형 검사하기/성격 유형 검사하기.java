class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] score = new int[26];   // 'A'~'Z' 인덱스

        for (int i = 0; i < survey.length; i++) {
            int c = choices[i];
            if (c < 4)      score[survey[i].charAt(0) - 'A'] += 4 - c;
            else if (c > 4) score[survey[i].charAt(1) - 'A'] += c - 4;
        }

        StringBuilder sb = new StringBuilder();
        String[] pairs = {"RT", "CF", "JM", "AN"};
        for (String p : pairs) {
            char a = p.charAt(0), b = p.charAt(1);
            sb.append(score[a - 'A'] >= score[b - 'A'] ? a : b);
        }
        return sb.toString();
    }
}