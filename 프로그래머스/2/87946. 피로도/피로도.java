class Solution {
    
    private boolean[] visited;  // 방문 여부
    private int count;          // 던전수
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        return dfs(0, k, dungeons);
    }
    
    private int dfs(int depth, int fatigue, int[][] dungeons) {
        for(int i=0; i<dungeons.length; i++) {
            if(visited[i] || dungeons[i][0] > fatigue) {
                continue;
            }
            
            visited[i] = true;  // 방문
            dfs(depth+1, fatigue-dungeons[i][1], dungeons);
            visited[i] = false; // 방문 초기화
        }
        return count = Math.max(count, depth);
    }
}