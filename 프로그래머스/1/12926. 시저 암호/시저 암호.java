class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(c>='a' && c<='z') {          // c가 소문자
                c = (char)((c + n -'a')%26 + 'a');
                answer += c;
                
            } else if(c>='A' && c<='Z') {   // c가 대문자
                c = (char)((c + n -'A')%26 + 'A');
                answer += c;
            } else if (c == ' ') {
                answer += ' ';
            }
        }
        
        return answer;
    }
}