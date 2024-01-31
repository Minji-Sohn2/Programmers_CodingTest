class Solution {
    public int solution(int[][] dots) {
        int[] point = dots[0];
        int height = 0;
        int width = 0;
        
        for(int i=1; i<dots.length; i++) {
            if(dots[i][0] == point[0]) {
                height = Math.abs(point[1]-dots[i][1]);
            } else if(dots[i][1] == point[1]) {
                width = Math.abs(point[0]-dots[i][0]);
            }
        }
        
        return height*width;
    }
}