import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times); // 심사관 정렬
        
        long start = 0;     // 최소 대기 시간
        long end = times[times.length-1] * (long)n; // 최대 대기 시간
        
        while(start<=end) {
            long mid = (start+end)/2;
            long complete = 0;      // 현재 대기 시간동안 처리 가능한 사람
            
            // 각 심사관 마다 현재 대기 시간동안 처리 가능한 사람 더하기
            for(int i=0; i<times.length; i++) {
                complete += mid/times[i];
            }
            
            // 처리 가능한 인원이 목표 인원보다 작으면 
            if(complete<n) {
                // 중간값 기준 오른쪽 절반 탐색
                start = mid+1;
            } else {
                // 처리 가능한 인원이 목표 인원보다 크거나 같으면 
                // 중간값 기준 왼쪽 절반 탐색
                end = mid-1;
                // 현재 대기 시간은 정답 후보
                answer = mid;
            }
        }
        return answer;
    }
}