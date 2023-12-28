import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int[] solution(int[] numbers) {
        List<Integer> sumList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if(!sumList.contains(numbers[i] + numbers[j])) {
                    sumList.add(numbers[i] + numbers[j]);
                }
            }
        }

        int[] sumArray = sumList.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(sumArray);
        return sumArray;
    }
}
