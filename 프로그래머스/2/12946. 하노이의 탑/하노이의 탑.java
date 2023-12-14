import java.util.*;

class Solution {
    private List<int[]> answerList;
    public int[][] solution(int n) {
        answerList = new ArrayList<>();
        hanoi(n, 1, 2, 3);
        
        return answerList.stream()
            .toArray(int[][]::new);
    }
    
    private void hanoi(int n, int start, int mid, int end) {
        if(n==0) {
            return;
        }
        
        hanoi(n-1, start, end, mid);
        answerList.add(new int[]{start, end});
        hanoi(n-1, mid, start, end);
    }
}