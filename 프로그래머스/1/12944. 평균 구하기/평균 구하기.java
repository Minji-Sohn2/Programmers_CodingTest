import java.util.*;

class Solution {
    public double solution(int[] arr) {
        int sum=0;
        
        for(int num : arr) {
            sum+=num;
        }
    
        return sum/(double)arr.length;
    }
}