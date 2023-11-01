import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int min = 100000;
        int max = -1;
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==2) {
                list.add(i);
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        
        if(max>=min) {
            return Arrays.copyOfRange(arr, min, max+1);
        } else {
            return new int[]{-1};
        }
    }
}