import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        if(n==1) {
            answer = Arrays.copyOfRange(num_list, 0, slicer[1]+1);
        } else if(n==2) {
            answer = Arrays.copyOfRange(num_list, slicer[0], num_list.length);
        } else if(n==3) {
            answer = Arrays.copyOfRange(num_list, slicer[0], slicer[1]+1);
        } else if(n==4) {
            for(int i=slicer[0]; i<=slicer[1]; i+=slicer[2]) {
                list.add(num_list[i]);
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
        
        
        
        return answer;
    }
}