import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);     // 인용 횟수 오름차순 정렬
        
        for(int i=0; i<citations.length; i++) {
            // 현재 논문 ~ 마지막 논문 개수
            int hIndex = citations.length - i;  
            
            // 인용된 횟수가 더 크다면
            if(citations[i] >= hIndex) {   
                return hIndex;
            }
        }
        return 0;
    }
}