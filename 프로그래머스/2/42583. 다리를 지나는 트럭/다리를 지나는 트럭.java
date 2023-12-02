import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0, sum = 0;
        int index = 0;
        // 다리 위의 트럭
        Queue<Integer> bridge = new LinkedList<>();
        
        // 다리 길이만큼 bridge(queue) 설정
        for(int i=0; i<bridge_length; i++) {
            bridge.offer(0);
        }
        
        while(index < truck_weights.length) {
            // 1초 지나고 한 트럭만큼 앞으로 이동
            int n = bridge.poll();
            sum -= n;
            // 지금 트럭이 다리 위로 올라갈 수 있을 때 -> 트럭 무게 추가
            if(sum+truck_weights[index] <= weight) {
                sum += truck_weights[index];
                bridge.offer(truck_weights[index++]);
            } else {    // 지금 올라갈 수 없을 때 -> 0(빈 칸) 추가
                bridge.offer(0);
            }
            
            time++;
        }
        
        // 트럭이 다 지나갈 때까지 time++
        while(!bridge.isEmpty()) {
            time++;
            bridge.poll();
        }
        
        return time;
    }
}