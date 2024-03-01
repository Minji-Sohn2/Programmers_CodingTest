import java.util.*;

class Solution {
    public int[] solution(String[] strlist) {
        
        return Arrays.stream(strlist)
                    .mapToInt(x -> x.length())
                    .toArray();
    }
}