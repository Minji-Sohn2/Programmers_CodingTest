import java.util.*;

class Solution {

    private long max;
    private List<Long> numList;
    private List<Character> opList;
    private char[] ops = {'+', '-', '*'};
    
    private char[] priorities;
    private boolean[] visited;

    public long solution(String expression) {
        init(expression);
        dfs(0);
        return max;
    }

    private void init(String expression) {
        max = 0;
        priorities = new char[3];
        visited = new boolean[3];
        char[] arr = expression.toCharArray();
        StringBuilder sb = new StringBuilder();
        numList = new ArrayList<>();
        opList = new ArrayList<>();
        
        for(char c : arr) {
            if(c=='+' || c=='-' || c=='*') {
                numList.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
                opList.add(c);
                continue;
            }
            sb.append(c);
        }
        // 끝 숫자 넣기
        numList.add(Long.parseLong(sb.toString()));
    }

    private void dfs(int depth) {
        
        if (depth == 3) {
            max = Math.max(Math.abs(calculateOp()), max);
            return;
        }

        for (int i = 0; i < ops.length; i++) {
            if (visited[i]) {
                continue;
            }

            priorities[depth] = ops[i];
            visited[i] = true;
            dfs(depth + 1);
            visited[i] = false;
        }
    }

    private long calculateOp() {
        List<Long> copyNumList = new ArrayList<>(numList);
        List<Character> copyOpList = new ArrayList<>(opList);
        while (copyOpList.size() > 0) {
            int maxPriority = 0;
            // 연산자 개수 확인 -> 우선순위 최대 구하기
            for (int i = 0; i < copyOpList.size(); i++) {
                maxPriority = Math.max(getPriority(copyOpList.get(i)), maxPriority);
            }
            for (int i = 0; i < copyOpList.size(); i++) {
                if (getPriority(copyOpList.get(i)) == maxPriority) {
                    copyNumList.add(i,
                        calculate(copyNumList.remove(i), copyNumList.remove(i),
                            copyOpList.remove(i)));
                    break;
                }
            }
        }
        
        return copyNumList.get(0);
    }

    // 연산
    public long calculate(long a, long b, char c) {
        switch(c) {
            case '+' :
                return a+b;
            case '-' :
                return a-b;
            case '*' :
                return a*b;
        }
        
        return 0;
    }

    private int getPriority(char op) {
        int priority;
        if (op == priorities[0]) {
            priority = 2;
        } else if (op == priorities[1]) {
            priority = 1;
        } else {
            priority = 0;
        }
        return priority;
    }
}