import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 결과 담을 리스트
        ArrayList<Integer> answer = new ArrayList<>();
        // 남은 일수 담을 큐
        Queue<Integer> q = new LinkedList<>();
        
        // 큐에 남은 일수 저장
        for(int i=0; i<progresses.length; i++) {
            // 올림으로 정수 만들기
            q.add((int)Math.ceil((100.0 - progresses[i])/speeds[i]));
        }
        
        // 남은 기능이 없을 때까지
        while(!q.isEmpty()) {
            int fin = q.poll();
            int cnt = 1;
            
            // 다음 기능도 이미 완성된 경우
            while(!q.isEmpty() && fin>=q.peek()) {
                cnt++;
                // 완성된 기능 제거
                q.poll();
            }
            answer.add(cnt);
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}