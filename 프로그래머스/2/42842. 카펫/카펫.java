class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int size = brown + yellow;
        
        for(int i=3; i<=size; i++) {
            if(size%i == 0) {
                int row = Math.min(i, size/i);
                int col = Math.max(i, size/i);
                
                // 이 경우 갈색 개수
                int bNum = 2 * (col + row -2);
                if(bNum == brown) {
                    answer[0] = col;
                    answer[1] = row;
                    break;
                }
            }
        }
        
        return answer;
    }
}