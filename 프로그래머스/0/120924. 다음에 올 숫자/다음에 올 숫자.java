class Solution {
    public int solution(int[] common) {
        int com = 0;
        
        if(common[1]-common[0] == common[2]-common[1]) {
            com = common[1]-common[0];
            return common[common.length-1] + com;
        } else {
            com = common[1]/common[0];
            return common[common.length-1] * com;
        }
        
    }
}