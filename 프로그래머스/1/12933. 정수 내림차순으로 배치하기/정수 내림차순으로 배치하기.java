import java.util.*;

class Solution {
    public long solution(long n) {
        String nStr = Long.toString(n);
        char[] nArr = nStr.toCharArray();
        
        Arrays.sort(nArr);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=nArr.length-1; i>=0 ; i--) {
            sb.append(nArr[i]);
        }
        
        return Long.parseLong(sb.toString());
    }
}