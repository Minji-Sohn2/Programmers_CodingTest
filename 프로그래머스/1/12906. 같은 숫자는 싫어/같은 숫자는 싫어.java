import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> list = new LinkedList<>();
        
        for(int i : arr) {
            if(list.isEmpty() || list.get(list.size()-1) != i) {
                 list.add(i);
            }
        }

        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}