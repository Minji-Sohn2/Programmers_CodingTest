class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int plen = p.length();
        long pLong = Long.parseLong(p);
        
        for(int i=0; i<t.length()-plen+1; i++) {
            long subLong = Long.parseLong(t.substring(i, i+plen));
            if(subLong <= pLong) {
                answer++;
            }
        }      
        
        return answer;
    }
}