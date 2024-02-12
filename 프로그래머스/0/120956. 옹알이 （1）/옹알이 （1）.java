public class Solution {
    
    private static String[] baby = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String say : babbling) {
            for(String b : baby) {
                if(say.contains(b)) {
                    say = say.replaceAll(b, " ");
                }
            }
            
            say = say.replaceAll(" ", "");
            
            if(say.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}
