class Solution {
    public int solution(int a, int b) {
        int nB = b/gcd(a,b);
        
        while(nB != 1) {
            if(nB % 2 == 0) {
                nB /= 2;
            } else if(nB % 5 == 0) {
                nB /= 5;
            } else {
                return 2;
            }
        }
        
        return 1;
    }
    
    // 유클리드 호제법 -> 최대공약수 구하기
    private int gcd(int a, int b) {
        if(b==0) {
            return a;
        }
        return gcd(b, a%b);
    }
}