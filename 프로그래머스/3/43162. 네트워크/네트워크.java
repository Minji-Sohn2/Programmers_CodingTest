import java.util.*;

class Solution {
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int cnt = 0;
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(computers, i);
                // dfs 종료 : 네트워크 완성
                cnt++;
            }
        }
        return cnt;
    }

    private void dfs(int[][] computers, int v) {
        // 현재 컴퓨터 방문
        visited[v] = true;
        
        // 현재 컴퓨터와 연결된 모든 컴퓨터 dfs 재귀
        for(int i = 0; i < computers.length; i++) {
            if(computers[v][i] == 1 && !visited[i]) {
                dfs(computers, i);
            }
        }
    }
}