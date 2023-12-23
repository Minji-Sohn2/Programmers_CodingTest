class Solution {
            
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1; i<=s.length()/2; i++) {
            int result = zipString(s, i, 1).length();
            answer = Math.min(answer, result);
        }
        
        return answer;
    }
    
    private String zipString(String s, int i, int cnt) {
        // s 에 들어올 string은 계속 짧아지기 때문에
        if(s.length() < i) {
           return s; 
        } 
        
        StringBuilder sb = new StringBuilder();
        String pre = s.substring(0,i);
        String post = s.substring(i, s.length());
        
        // post의 시작과 pre 가 다르면
        if(!post.startsWith(pre)) {
            sb.append((cnt == 1) ? pre : cnt + pre);
            sb.append(zipString(post, i, 1));
        } else {
            sb.append(zipString(post, i, ++cnt));
        }
        
        return sb.toString();
    }
}