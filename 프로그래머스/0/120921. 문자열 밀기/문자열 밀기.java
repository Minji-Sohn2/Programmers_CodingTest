class Solution {
    public int solution(String A, String B) {
        int answer = 0;
  
        for(int i=0; i<A.length(); i++) {            
            String newA = rotateString(A, i);
            if(newA.equals(B)) {
                return answer;
            }
            answer++;
        }
        
        return -1;
    }
    
    private String rotateString(String str, int count) {
        return str.substring(str.length()-count) + str.substring(0, str.length()-count);
    }
}