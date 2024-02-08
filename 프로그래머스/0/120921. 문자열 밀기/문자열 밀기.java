class Solution {
    public int solution(String A, String B) {
        int answer = 0;
  
        for(int i=0; i<A.length(); i++) {            
            String newA = A.substring(A.length()-i) + A.substring(0, A.length()-i);
            if(newA.equals(B)) {
                return answer;
            }
            answer++;
        }
        
        return -1;
    }
}