class Solution {
            
    public int solution(String s) {
        
        int answer = s.length();
        
        if(s.length()==1) return 1;
                
        for(int i=1; i<=s.length()/2; i++) {
            String unit = s.substring(0,i); // 단위
            int cnt = 1;     // 단위 반복 횟수
            StringBuilder sb = new StringBuilder();
            
            for(int j=i; j<=s.length(); j+=i) {
                // 다음 i 길이의 문자열
                String nextUnit = s.substring(j, (j + i > s.length()) ? s.length() : j + i);
                    
                if(unit.equals(nextUnit)) {
                    cnt++;
                } else {
                    // 반복이 있는 경우 반복 횟수 문자열에 추가
                    if(cnt>1) {
                        sb.append(cnt);
                    }
                    sb.append(unit);
                    unit = nextUnit;
                    cnt = 1;
                }
            }
            
            sb.append(unit);
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}