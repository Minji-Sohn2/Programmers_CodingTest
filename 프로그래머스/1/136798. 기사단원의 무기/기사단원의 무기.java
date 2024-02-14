class Solution {
    public int solution(int number, int limit, int power) {
        int[] divArr = new int[number];
        int answer = 0;
        
        for(int i=1; i<=number; i++) {
            int attackP = countDivisors(i);
            if(attackP > limit) {
                attackP = power;
            }
            
            answer += attackP;
        }

        return answer;
    }
    
    private int countDivisors(int number) {
        int count = 0;
        
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {          // i가 number의 약수일 때
                if (i != number / i) {      // i가 number의 제곱근이 아니라면
                    count += 2;
                } else {
                    count += 1;             // i가 number의 제곱근이라면
                }
            }
        }
        
        return count;
    }
}