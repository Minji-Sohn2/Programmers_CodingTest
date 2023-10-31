import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        List<Integer> answer = new ArrayList<>();
        int i = 1;
        while(i*k <= n) {
            answer.add(i*k);
            i++;
        }
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}