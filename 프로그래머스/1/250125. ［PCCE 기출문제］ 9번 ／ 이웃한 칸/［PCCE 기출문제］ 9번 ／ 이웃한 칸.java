class Solution {
    public int solution(String[][] board, int h, int w) {
        String current = board[h][w];
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        int count = 0;
        
        for(int i=0; i<4; i++) {
            int nh = h + dh[i];
            int nw = w + dw[i];
            
            if(nh >= 0 && nh < board.length && nw >= 0 && nw < board.length) {
                if(board[nh][nw].equals(current)) {
                    count += 1;
                }
            }
            
        }
        
        return count;
    }

}