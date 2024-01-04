import java.util.*;

class Solution {

    static HashMap<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answerList = new ArrayList<>();

        // 1. 각 주문 문자열을 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        // 2. 주문 문자열에서 가능한 조합 찾기
        for (int courseLength : course) {
            map = new HashMap<>();
            int maxCount = Integer.MIN_VALUE;

            for (String order : orders) {
                if (courseLength <= order.length()) {
                    StringBuilder sb = new StringBuilder();
                    generateCombinations(order, sb, 0, 0, courseLength);
                }
            }

            // 3. 최대 주문 횟수 찾기
            for (int count : map.values()) {
                maxCount = Math.max(maxCount, count);
            }

            // 4. 최대 주문 횟수와 일치하는 조합 추가
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (maxCount >= 2 && entry.getValue() == maxCount) {
                    answerList.add(entry.getKey());
                }
            }
        }

        // 5. 조합들을 오름차순 정렬
        Collections.sort(answerList);

        // 6. 최종 결과를 String 배열로 변환
        String[] answer = answerList.toArray(new String[0]);
        
        return answer;
    }
    
    // 7. 조합을 구하는 메소드
    // 길이 n인 모든 문자열의 조합
    private static void generateCombinations(String str, StringBuilder sb, int idx, int cnt, int n) {
        if (cnt == n) {
            // 조합을 해시맵에 저장 or 기존 조합 cnt +1
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        // 8. 주문 문자열에서 가능한 조합을 재귀적으로 찾기
        for (int i = idx; i < str.length(); i++) {
            sb.append(str.charAt(i));
            generateCombinations(str, sb, i + 1, cnt + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
