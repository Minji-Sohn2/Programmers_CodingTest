import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 옷 종류 - 개수
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] clothes_arr : clothes) {
            String type = clothes_arr[1];
            map.put(type, map.getOrDefault(type, 1) + 1);
        }
        
        for(String key : map.keySet()) {
            answer *= map.get(key);
        }
        
        return answer-1;
    }
}