

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()){
            int cnt = 0;
            int idx = c - 'a';
            while(cnt < index){
                idx++;
                c = (char) ((idx % 26) + 'a');
                if(skip.indexOf(c) == -1) cnt++;
            }
            sb.append(c);
        }
        
        return  sb.toString();
    }
}