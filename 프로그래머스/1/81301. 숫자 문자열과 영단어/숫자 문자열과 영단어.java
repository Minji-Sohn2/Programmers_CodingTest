class Solution {
    public int solution(String s) {
        String[] numberInt = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] numberString = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<10; i++) {
            s = s.replace(numberString[i], numberInt[i]);
        }
        
        return Integer.parseInt(s);
    }
}