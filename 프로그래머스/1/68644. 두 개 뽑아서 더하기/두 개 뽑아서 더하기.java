import java.util.*;

class Solution {
    
    private Set<Integer> set;
    
    public int[] solution(int[] numbers) {
        set = new HashSet<>();
        calculate(numbers);
        return setToArr(set);
    }
    
    private void calculate(int[] numbers) {
        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
    }
    
    private int[] setToArr(Set<Integer> set) {
        return set.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}