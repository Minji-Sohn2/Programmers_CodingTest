class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(String num : s.split(" ")) {
            max = Math.max(max, Integer.parseInt(num));
            min = Math.min(min, Integer.parseInt(num));
        }
        
        return min + " " + max;
    }
}