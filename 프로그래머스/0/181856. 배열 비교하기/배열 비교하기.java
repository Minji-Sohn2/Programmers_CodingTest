import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int sumArr1 = calculateSum(arr1);
        int sumArr2 = calculateSum(arr2);

        if (arr1.length != arr2.length) {
            return Integer.compare(arr1.length, arr2.length);
        } else {
            return Integer.compare(sumArr1, sumArr2);
        }
    }

    private int calculateSum(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}
