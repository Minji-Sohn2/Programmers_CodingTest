import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int size = 0;
        for(int n : arr) {
            size += n;
        }
        
        int[] answer = new int[size];
        int idx = 0;
        for(int n : arr) {
            Arrays.fill(answer, idx, idx + n, n);
            idx += n;
        }
        
        return answer;
    }
}