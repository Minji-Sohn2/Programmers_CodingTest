class Solution {
    private final int[] dx = {-1, 1, 0, 0};  // 왼,오,아래,위
    private final int[] dy = {0, 0, -1, 1};  // 왼,오,아래,위
    private char[][] matrix;         // 대기실
    private boolean[][] visited;     // 탐색했던 자리인지 확인
    private boolean isAvailable;     // 거리두기를 지켰는지 확인

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            isAvailable = true;
            matrix = new char[5][5];

            // 대기실 matrix 만들기
            for (int j = 0; j < 5; j++) {
                matrix[j] = places[i][j].toCharArray();
            }

            // 사람이 있는 경우에만 확인 시작
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (matrix[r][c] == 'P') {
                        visited = new boolean[5][5];
                        dfs(0, r, c);
                        if (!isAvailable) {
                            break;
                        }
                    }
                }
                if (!isAvailable) break;
            }

            answer[i] = (!isAvailable) ? 0 : 1;
        }

        return answer;
    }

    private void dfs(int currentDepth, int r, int c) {
        if (currentDepth >= 2) return;
        visited[r][c] = true;

        // 앞, 뒤, 양 옆 확인
        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || visited[nr][nc]) continue;

            // 옆자리가 테이블인 경우
            if (matrix[nr][nc] == 'O') {
                dfs(currentDepth + 1, nr, nc);
            } else if (matrix[nr][nc] == 'P') {
                // 옆자리가 사람인 경우 종료
                isAvailable = false;
                return;
            }
        }
    }
}
