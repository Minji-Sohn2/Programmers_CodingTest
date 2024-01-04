import java.util.*;

class Solution {
    
    public boolean solution(String[] phone_book) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        
        for (String key : map.keySet()) {
            String prefix = "";
            for (char num : key.toCharArray()) {
                prefix += num;

                if (map.containsKey(prefix) && !prefix.equals(key)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}