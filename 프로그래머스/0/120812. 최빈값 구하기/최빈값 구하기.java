import java.util.*;

class Solution {
    public int solution(int[] array) {
        int maxCount = Integer.MIN_VALUE;
        int maxKey = Integer.MIN_VALUE;
        Map<Integer, Integer> numMap = new HashMap<>();
        
        for(int num : array) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxKey = entry.getKey();
            } else if (entry.getValue() == maxCount) {
                maxKey = -1;
            }
        }
        
        return maxKey==Integer.MIN_VALUE ? -1 : maxKey;
    }
}