import java.util.*;

class Solution {
    private static final int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
    private List<Group> oilGroups = new ArrayList<>();
    private int width, height;
    private boolean[][] visited;
    private int[][] land;
    
    // 석유 덩어리 그룹 클래스 정의
    public class Group {
        int count;
        Set<Integer> possibleY;

        public Group(Set<Integer> possibleY, int count) {
            this.possibleY = possibleY;
            this.count = count;
        }
    }

    public int solution(int[][] land) {
        this.land = land;
        initGroups(land);
        int maxNum = calculateMaxOilCount();
        return maxNum;
    }

    private void initGroups(int[][] land) {
        visited = new boolean[land.length][land[0].length];
        height = land.length;
        width = land[0].length;

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                // 이미 방문한 땅이거나 석유가 없으면 패스
                if (land[i][j]==1 && !visited[i][j]) {
                    oilGroups.add(bfs(i, j));
                } 
            }
        }
    }

    // 최대 석유 양 계산
    private int calculateMaxOilCount() {
        int maxNum = 0;
        int[] answer = new int[width];

        for (Group group : oilGroups) {
            for (Integer offset : group.possibleY) {
                answer[offset] += group.count;
                maxNum = Math.max(maxNum, answer[offset]);
            }
        }

        return maxNum;
    }

    // BFS로 석유 덩어리 생성
    private Group bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> possibleY = new HashSet<>();
        int size = 1;
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        possibleY.add(y);

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int currentX = temp[0];
            int currentY = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = currentX + d[i][0];
                int ny = currentY + d[i][1];

                // 위치가 유효하고 땅 내부이며 석유가 있으며 아직 방문하지 않았다면
                if (isInvalidPosition(nx, ny) || land[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
                size++;
                possibleY.add(ny);
            }
        }

        return new Group(possibleY, size);
    }

    // 위치가 유효한지 확인하는 메서드
    private boolean isInvalidPosition(int x, int y) {
        return x < 0 || y < 0 || x >= height || y >= width;
    }

}
