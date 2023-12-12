import java.util.*;

class Solution {
    private List<String> list= new ArrayList<>();
    private String[] arr = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        recursion("", 0);
        return list.indexOf(word);
    }
    
    public void recursion(String str, int depth) {
        list.add(str);
        
        if(depth==5) {
            return;
        }
        
        for(int i=0; i<5; i++) {
            recursion(str+arr[i], depth+1);
        }
    }
}