import java.util.*;

class Solution {
    
    public boolean solution(String[] phone_book) {
        
        // 전화번호와 해당 인덱스를 저장하기 위한 HashMap 생성
        Map<String, Integer> map = new HashMap<>();
        
        // HashMap에 각 전화번호와 인덱스를 저장
        for(int i=0; i<phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        
        // 각 전화번호에 대해 반복
        for (String key : map.keySet()) {
            String prefix = "";
            
            // 전화번호의 각 숫자에 대해 반복
            for (char num : key.toCharArray()) {
                prefix += num;

                // 현재까지의 접두사가 HashMap에 존재하면서 현재 전화번호와 다른 경우, false 반환
                if (map.containsKey(prefix) && !prefix.equals(key)) {
                    return false;
                }
            }
        }
        
        // 모든 전화번호에 대한 검사를 완료하면 true 반환
        return true;
    }
}
