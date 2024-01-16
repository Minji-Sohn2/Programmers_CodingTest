import java.util.*;

class Solution {
    // 아래, 위, 오른, 왼
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int[][] visited;
    private Queue<int[]> queue = new LinkedList<>();
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        visited = new int[n][m]; 

        bfs(maps, visited, n, m);
        
        int answer = visited[n - 1][m - 1];

        return (answer > 0) ? answer : -1;
    }

    private void bfs(int[][] maps, int[][] visited, int numRows, int numCols) {
        // 시작 위치 추가
        visited[0][0] = 1;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            // 아래,위,오른,왼 탐색
            for (int i = 0; i < 4; i++) {
                int newRow = currentRow + d[i][0];
                int newCol = currentCol + d[i][1];

                // 맵의 끝이 아니고, 방문하지 않았고
                if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols) {
                    if (visited[newRow][newCol] == 0 && maps[newRow][newCol] == 1) {
                        queue.add(new int[]{newRow, newCol});
                        visited[newRow][newCol] = visited[currentRow][currentCol] + 1;
                    }
                }
            }
        }
    }
}
