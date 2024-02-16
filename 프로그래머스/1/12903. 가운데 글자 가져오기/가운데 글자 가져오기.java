class Solution {
    public String solution(String s) {
        int sLen = s.length();
        int startIndex = (sLen - 1) / 2;
        int endIndex = sLen / 2 + 1;
        
        return s.substring(startIndex, endIndex);
    }
}
