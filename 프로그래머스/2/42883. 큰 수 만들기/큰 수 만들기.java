public class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int currentIndex = 0;
        int maxIndex = 0;

        // 생성할 숫자의 길이만큼 반복
        for (int i = 0; i < number.length() - k; i++) {
            // 범위 내에서 가장 큰 숫자의 인덱스 찾기
            maxIndex = findMaxIndex(number, currentIndex, k + i);
            // 해당 인덱스의 숫자 붙이기
            answer.append(number.charAt(maxIndex));
            // 가장 큰 숫자 다음 부터로 범위 변경
            currentIndex = maxIndex + 1;
        }
        return answer.toString();
    }

    // 범위 내에서 가장 큰 숫자의 인덱스 찾기
    private int findMaxIndex(String number, int start, int end) {
        int maxIndex = start;
        int max = -1;

        for (int i = start; i <= end; i++) {
            // char -> int
            int current = number.charAt(i) - '0';

            // 가장 큰 숫자와 인덱스 저장
            if (current > max) {
                max = current;
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
