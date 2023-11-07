import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String,Integer> pMap = new HashMap<>();
        
        for(String name : participant) {
            pMap.put(name, pMap.getOrDefault(name, 0) + 1);
        }
        
        for(String name : completion) {
            pMap.put(name, pMap.getOrDefault(name, 0) - 1);
        }
        
        for(String key : pMap.keySet()) {
            if(pMap.get(key) != 0) {
                return key;
            }
        }
        
        return null;
    }
}