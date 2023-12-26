import java.util.*;

class Solution {
    
    private List<Integer> maxes;
    private List<Integer> mins;
    
    public int solution(int[][] sizes) {        
        maxes = new ArrayList<>();
        mins = new ArrayList<>();
        
        sort(sizes);
        
        return calMax();
    }
    
    private void sort(int[][] sizes) {
        for(int[] card : sizes) {
            mins.add(Math.min(card[0], card[1]));
            maxes.add(Math.max(card[0], card[1]));
        }
    }
    
    private int calMax() {
        int width = Collections.max(maxes);
        int height = Collections.max(mins);
        
        return width*height;
    }
}