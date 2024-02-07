class Solution {
    private static String[][] numString = {{"zero","0"},{"one","1"},{"two","2"},{"three","3"},{"four","4"},{"five","5"},{"six","6"},{"seven","7"},{"eight","8"},{"nine","9"}};
    
    public long solution(String numbers) {
        if(numbers.startsWith(numString[0][0])) {
            numbers = numbers.substring(4);
        }
        
        for(String[] num : numString) {
            if(numbers.contains(num[0])) {
                numbers = numbers.replaceAll(num[0],num[1]);
            }
        }
        
        return Long.parseLong(numbers);
    }
}