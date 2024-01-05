class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        int div = 1000000007;
        dp[1][1] = 1;

        // 웅덩이 초기화
        for (int[] puddle : puddles) {
            int x = puddle[1];
            int y = puddle[0];
            dp[x][y] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i > 1 || j > 1) {
                    int left = (j > 1) ? dp[i][j - 1] : 0;
                    int up = (i > 1) ? dp[i - 1][j] : 0;

                    dp[i][j] = (left + up) % div;
                }
            }
        }

        return dp[n][m];
    }
}
