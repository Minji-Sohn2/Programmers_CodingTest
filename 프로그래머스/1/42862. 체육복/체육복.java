import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 수업을 들을 수 있는 학생 수
        int answer = n-lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 도난당했지만 여분의 체육복이 있는 경우
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i]==reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        // 체육복을 빌릴 수 있는 경우
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(Math.abs(reserve[j]-lost[i]) == 1) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}