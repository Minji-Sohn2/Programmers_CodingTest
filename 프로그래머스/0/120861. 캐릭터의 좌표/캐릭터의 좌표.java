class Solution {
    
    
    public int[] solution(String[] keyinput, int[] board) {
        int[] current = new int[2];
        int maxWidth = board[0]/2;
        int maxHeight = board[1]/2;
                
        for(String key : keyinput) {
            if(key.equals("up") && (current[1]+1 <= maxHeight)) {
                current[1] += 1;
            } else if(key.equals("down") && (current[1]-1 >= -maxHeight)) {
                current[1] -= 1;
            } else if(key.equals("left") && (current[0]-1 >= -maxWidth)) {
                current[0] -= 1;
            } else if(key.equals("right") && (current[0]+1 <= maxWidth)) {
                current[0] += 1;
            } 
        }
        
        return current;
    }

}