import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        double slope1 = getSlope(dots[0], dots[1]);
        double slope2 = getSlope(dots[2], dots[3]);
        if(slope1==slope2) {
            return 1;
        }
        
        slope1 = getSlope(dots[0], dots[2]);
        slope2 = getSlope(dots[1], dots[3]);
        if(slope1==slope2) {
            return 1;
        }
        
        slope1 = getSlope(dots[0], dots[3]);
        slope2 = getSlope(dots[1], dots[2]);
        if(slope1==slope2) {
            return 1;
        }
        
        return 0;
    }
    
    public double getSlope(int[] dot1, int[] dot2) {
        return (double)(dot1[1]-dot2[1])/(dot1[0]-dot2[0]);
    }
}