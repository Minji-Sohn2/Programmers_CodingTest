import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sArr = s.split("");
        int index = 0;
        
        for(int i=0; i<s.length(); i++) {
            String str = sArr[i];
            // 공백 -> 단어 끝
            if(str.equals(" ")) {
                // index 초기화
                index = 0;
                answer += " ";
                continue;
            }
            
            if(index%2 == 0) {
                str = str.toUpperCase();
                answer += str;
            } else {
                str = str.toLowerCase();
                answer += str;
            }
            
            index++;
        }
        return answer;
    }
}