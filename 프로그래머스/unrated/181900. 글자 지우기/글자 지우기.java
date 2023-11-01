import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        
        StringBuilder answer = new StringBuilder(my_string);
        Set<Integer> indicesSet = new HashSet<>();
        
        for(int i : indices) {
            indicesSet.add(i);
        }
        
        for(int i=my_string.length()-1; i>=0; i--) {
            if(indicesSet.contains(i)){
                answer.deleteCharAt(i);
            }
        }
        
        return answer.toString();
    }
}