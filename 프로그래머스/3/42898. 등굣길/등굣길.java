class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];
        int div = 1000000007;
        map[1][1] = 1;

        // 웅덩이 초기화
        for (int[] puddle : puddles) {
            int x = puddle[1];
            int y = puddle[0];
            map[x][y] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 물 웅덩이를 만나면
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }

                if (i!=1) {
                    map[i][j] += map[i-1][j]%div;
                }
                if (j!=1) {
                    map[i][j] += map[i][j-1]%div;
                }
            }
        }

        return map[n][m]%div;
    }
}
