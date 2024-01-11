import java.util.*;

class Solution {
    
    static List<Set<Integer>> setList;
    
    public int solution(int N, int number) {
        
        if(N==number) {
            return 1;
        }
        
        setList = new ArrayList<>();
        //index는 N이 쓰인 횟수
        for(int i=0; i<9; i++) {
            setList.add(new HashSet<>());
        }
        
        // N 1개
        setList.get(1).add(N);
        
        // N 2개 이상
        for(int i=2; i<9; i++) {
            for(int j=1; j<=i; j++) {
                unionSet(setList.get(i), setList.get(i-j), setList.get(j));
                unionSet(setList.get(i), setList.get(j), setList.get(i-j));
            }
            
            // 숫자 i개 이어붙인 숫자 추가
            String n = Integer.toString(N);
            setList.get(i).add(Integer.parseInt(n.repeat(i)));
            
            for(int num : setList.get(i)) {
                if(num == number) {
                    return i;
                }
            }
        }
        
        return -1;
    }
    
    private void unionSet(Set<Integer> unionSet, Set<Integer> set1, Set<Integer> set2) {
        for(int i : set1) {
            for(int j : set2) {
                unionSet.add(i+j);
                unionSet.add(i-j);
                unionSet.add(i*j);
                if(j!=0) {
                    unionSet.add(i/j);
                }
            }
        }
    }
}