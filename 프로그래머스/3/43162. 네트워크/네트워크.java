import java.util.*;

class Solution {
    
    private boolean[] visited;
    private Queue<Integer> queue = new LinkedList<>();
    
    public int solution(int n, int[][] computers) {
        int answer=0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            // 아직 방문하지 않은 컴퓨터라면
            if(!visited[i]) {
                bfs(i, computers, n);
                answer++;
            }
        }
        
        return answer;
    }
    
    // queue에 방문할 노드를 넣어두고 하나씩 뽑아가며 연결된 노드를 다시 넣음
    private void bfs(int start, int[][] computers, int n) {
        queue.offer(start);
        visited[start]=true;
        
        while(!queue.isEmpty()) {
            // 현재 방문 노드
            int current = queue.poll();
            
            // 현재 노드와 연결된 노드들 확인
            for(int connect=0; connect<n; connect++) {
                // 아직 방문하지 않았고 현재 노드와 연결된 경우
                if(!visited[connect] && computers[current][connect]==1) {
                    visited[connect]=true;
                    queue.offer(connect);
                }
            }
        }
    }
}