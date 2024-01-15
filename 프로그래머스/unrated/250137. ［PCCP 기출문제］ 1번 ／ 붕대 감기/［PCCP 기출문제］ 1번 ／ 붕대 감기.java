import java.util.*;

class Solution {

    public int solution(int[] bandage, int health, int[][] attacks) {
        int bandageTime = bandage[0];   // 시전 시간
        int bandagePerSec = bandage[1];  // 초당 회복량
        int bandageBonus = bandage[2];    // 추가 회복량

        int remainingHealth = health;   // 남은 체력
        int lastAttackTime = 0; // 마지막으로 공격당한 시간

        for (int[] attack : attacks) {

            int timeDifference = attack[0] - lastAttackTime - 1;   // 공격 사이의 시간 간격
            int immediateRecovery = timeDifference * bandagePerSec;   // 초당 회복량 계산
            int regularRecovery = (timeDifference / bandageTime) * bandageBonus;   // 추가 회복량 계산

            // 최대 체력 초과하지 않도록
            remainingHealth = Math.min(health, remainingHealth + immediateRecovery + regularRecovery);
            remainingHealth -= attack[1];   // 공격으로 감소된 체력 계산

            lastAttackTime = attack[0];
            
            if (remainingHealth <= 0) {
                return -1; // 종료
            }
        }

        return remainingHealth;
    }
}
