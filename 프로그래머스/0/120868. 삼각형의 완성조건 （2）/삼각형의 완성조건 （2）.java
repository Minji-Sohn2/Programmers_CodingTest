import java.util.*;

class Solution {
    public int solution(int[] sides) {
        
        Arrays.sort(sides);
        int min = sides[0];
        int max = sides[1];
        
        return (min+max)-(max-min+1);
    }
}