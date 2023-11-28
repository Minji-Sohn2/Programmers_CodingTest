import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        // 높은 숫자가 우선인 priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 큐에 프로세스 우선순위 넣기
        for(int priority : priorities) {
            pq.offer(priority);
        }
        
        // 큐가 빌 때까지(프로세스 모두 실행)
        while(!pq.isEmpty()) {
            // i : 프로세스 위치(location과 비교)
            for(int i=0; i<priorities.length; i++) {
                // pq.peek() : 우선순위 가장 높은 것
                if(priorities[i] == pq.peek()) {
                    // 현재 위치 == location
                    if(i == location) {
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        
        return answer;
    }
}