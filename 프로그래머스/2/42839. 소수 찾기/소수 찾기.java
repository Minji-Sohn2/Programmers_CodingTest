import java.util.*;

import java.util.HashSet;
import java.util.Iterator;

class Solution {
    
    HashSet<Integer> numbersSet = new HashSet<>();

    public int solution(String numbers) {
        // 1. 모든 조합의 숫자를 만든다.
        recursive("", numbers);

        // 2. 소수의 개수만 세서 반환한다.
        return countPrime();
    }
    
    public void recursive(String str, String others) {
        // 1. 현재 조합을 set에 추가한다.
        if (!str.equals(""))
            numbersSet.add(Integer.valueOf(str));

        // 2. 남은 숫자 중 한 개를 더해 새로운 조합을 만든다.
        for (int i = 0; i < others.length(); i++)
            recursive(str + others.charAt(i), others.substring(0, i) + others.substring(i + 1));

    }
    
    public boolean isPrime(int num) {
        // 1. 0과 1은 소수가 아니다
        if (num == 0 || num == 1)
            return false;

        // 2. 에라토스테네스의 체의 limit 숫자를 계산한다.
        int lim = (int)Math.sqrt(num);

        // 3. 에라토스테네스의 체에 따라 lim까지 배수 여부를 확인한다.
        for (int i = 2; i <= lim; i++)
            if (num % i == 0)
                return false;

        return true;
    }
    
    private int countPrime() {
        int cnt = 0;
        
        Iterator<Integer> it = numbersSet.iterator();
        while (it.hasNext()) {
            int number = it.next();
            if (isPrime(number))
                cnt++;
        }
        
        return cnt;
    }

}
