import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> tritArr = new ArrayList<>();
        
        // 10진법 -> 3진법
        while(n>0) {
            // List에 거꾸로 저장
            tritArr.add(n%3);
            n/=3;
        }
        
        int trit = 1;
        // 뒤집힌 3진법 -> 10진법
        for(int i = tritArr.size()-1; i>=0; i--) {
            answer += tritArr.get(i)*trit;
            trit*=3;
        }
        
        return answer;
    }
}