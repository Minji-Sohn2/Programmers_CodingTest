class Solution {
    
    // 1. 첫번째 집 or 두번째 집 선택
    // 2. n-2, n-3번째 집과 비교해 더 큰 경우 선택해서 n과 더한 값 저장
    
    public int solution(int[] money) {
        int[] dp_first = new int[money.length];
        int[] dp_second = new int[money.length];
        
        for(int i=0; i<money.length; i++) {
            dp_first[i] = money[i];
            dp_second[i] = money[i];
        }
        
        dp_first[1] = -1;
        dp_first[2] += dp_first[0];
        dp_second[0] = -1;
        
        for(int i=3; i<money.length; i++) {
            dp_first[i] += Math.max(dp_first[i-2], dp_first[i-3]);
            dp_second[i] += Math.max(dp_second[i-2], dp_second[i-3]);
        }
        
        int max_first = Math.max(dp_first[money.length-2], dp_first[money.length-3]);
        int max_second = Math.max(dp_second[money.length-1], dp_second[money.length-2]);
        
        return Math.max(max_first, max_second);
    }
}