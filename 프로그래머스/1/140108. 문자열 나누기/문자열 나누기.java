class Solution {
    public int solution(String s) {
        int answer = 1;
        char x = s.charAt(0);
        int xCnt = 1;
        
        for(int i=1; i<s.length(); i++) {
            if(xCnt==0) {
                answer++;
                x = s.charAt(i);
            }
            
            if(x==s.charAt(i)) {
                xCnt++;
            } else {
                xCnt--;
            }   
        }
        
        return answer;
    }
}