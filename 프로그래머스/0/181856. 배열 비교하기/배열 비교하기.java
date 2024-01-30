class Solution {
    public int solution(int[] arr1, int[] arr2) {
    
        if(arr1.length != arr2.length) {
            return arr1.length > arr2.length ? 1 : -1;
        } else {
            if(calculateSum(arr1) != calculateSum(arr2)) {
                return calculateSum(arr1) > calculateSum(arr2) ? 1 : -1;
            } else {
                return 0;
            }
        }
    }
    
    private int calculateSum(int[] arr) {
        int sum = 0;
        for(int num : arr) {
            sum += num;
        }
        
        return sum;
    }
}