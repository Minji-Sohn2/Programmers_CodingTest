import java.util.*;

class Solution {
    
    public boolean solution(String[] phone_book) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        
        for (String key : map.keySet()) {
            String arr = "";
            for (char num : key.toCharArray()) {
                arr += num;

                if (map.containsKey(arr) && !arr.equals(key)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}