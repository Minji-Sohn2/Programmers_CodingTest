import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        
        for(int num : arr) {
            answer.addAll(Collections.nCopies(num, num));
        }
        
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}