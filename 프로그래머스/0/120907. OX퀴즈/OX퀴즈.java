class Solution {
    public String[] solution(String[] quiz) {
        String[] splitQ = new String[5];
        String[] answer = new String[quiz.length];
        
        for(int i=0; i<quiz.length; i++) {
            splitQ = quiz[i].split(" ");
            answer[i] = calculate(splitQ);
        }
        
        return answer;
    }
    
    private String calculate(String[] equation) {
        int result = 0;
        
        if (equation[1].equals("+")) {
            result = Integer.parseInt(equation[0]) + Integer.parseInt(equation[2]);
        } else if (equation[1].equals("-")) {
            result = Integer.parseInt(equation[0]) - Integer.parseInt(equation[2]);
        }
        
        return (result == Integer.parseInt(equation[4])) ? "O" : "X";
    }
}