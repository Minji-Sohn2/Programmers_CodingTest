import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> burgers = new Stack<>();
        
        for(int i : ingredient) {
            burgers.push(i);
            
            if(burgers.size() >= 4) {
                if(burgers.get(burgers.size()-1) == 1
                  && burgers.get(burgers.size()-2) == 3
                  && burgers.get(burgers.size()-3) == 2
                  && burgers.get(burgers.size()-4) == 1) {
                    answer++;
                    
                    burgers.pop();
                    burgers.pop();
                    burgers.pop();
                    burgers.pop();
                }
            }
        }
        
        return answer;
    }
}