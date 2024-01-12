import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int removedRockCnt = getRemovedRockCnt(rocks, mid, distance);

            if (removedRockCnt <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private int getRemovedRockCnt(int[] rocks, int mid, int distance) {
        int start = 0;
        int end = distance;
        int removeCnt = 0;

        for (int rock : rocks) {
            if (rock - start < mid) {
                removeCnt++;
            } else {
                start = rock;
            }
        }

        if (end - start < mid) {
            removeCnt++;
        }

        return removeCnt;
    }
}
