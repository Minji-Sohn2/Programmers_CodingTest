import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int zeroCnt = 0;
        int cnt = 0;

        while(s.length() > 1){
            // 0의 개수
            int beforeLen = s.length();
            s = s.replaceAll("0", "");
            zeroCnt += (beforeLen - s.length());
            
            s = Integer.toBinaryString(s.length());
            cnt++;
        }

        answer[0] = cnt;
        answer[1] = zeroCnt;

        return answer;
    }
}