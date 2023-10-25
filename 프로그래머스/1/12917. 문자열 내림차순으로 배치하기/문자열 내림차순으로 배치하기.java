import java.util.*;

class Solution {
    public String solution(String s) {
        char[] sArr = s.toCharArray();
        char[] sArrReverse = new char[sArr.length];
        Arrays.sort(sArr);
        for(int i=0; i<sArr.length; i++) {
            sArrReverse[i] = sArr[sArr.length-1-i];
        }
        
        return String.valueOf(sArrReverse);
    }
}