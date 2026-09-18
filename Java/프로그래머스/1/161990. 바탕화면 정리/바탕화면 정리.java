class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = 51, luy = 51, rdx = -1, rdy = -1;
    
        for(int i = 0 ; i < wallpaper.length; i++){
            for(int j = 0 ; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#') {
                    if(i < lux) lux = i;
                    if(j < luy) luy = j;
                    if(i > rdx) rdx = i;
                    if(j > rdy) rdy = j;
                } 
            }
        }

        return new int[]{lux, luy, rdx + 1, rdy + 1}; //끝점은 오른쪽 아래 모서리
    }
}