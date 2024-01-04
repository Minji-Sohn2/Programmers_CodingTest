import java.util.*;

class Solution {
    // <가능한 조합 - List<지원자들의 점수>>
    static Map<String, List<Integer>> map;

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        // info -> 가능한 모든 조합 생성
        for (String infoItem : info) {
            // 지원자 정보 배열로 변환
            String[] personInfo = infoItem.split(" ");
            generateCombinations(personInfo, "", 0);
        }

        // 코테 점수 정렬
        for (List<Integer> scores : map.values()) {
            Collections.sort(scores);
        }

        // 각 쿼리 이분탐색 -> 배열에 결과 저장
        for (int i = 0; i < query.length; i++) {
            // 쿼리에서 and 제거
            query[i] = query[i].replaceAll(" and ", "");
            // 쿼리 정보 배열로 변환
            //[0] : 조건 이어붙인 string, [1] : 점수
            String[] queryInfo = query[i].split(" ");
            answer[i] = map.containsKey(queryInfo[0]) ? binarySearch(queryInfo[0], Integer.parseInt(queryInfo[1])) : 0;
        }

        return answer;
    }

    // 이분탐색 -> 특정 점수 이상 인원 수 반환
    private static int binarySearch(String key, int score) {
        List<Integer> scores = map.get(key);
        int start = 0;      // 조건 만족하는 가장 낮은 점수를 가진 사람의 index
        int end = scores.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (scores.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return scores.size() - start;   // 전체 인원 - 가장 낮은 점수 index
    }

    // info -> 가능한 모든 조합 생성
    private static void generateCombinations(String[] personInfo, String str, int count) {
        // 언어, 직군, 경력, 소울푸드를 모두 선택했을 때
        if (count == 4) {
            // 맵에 해당 key가 존재하지 않을 때
            // <지원자 정보 조합(str) - new ArrayList<>()> 생성 후 점수 add
            map.computeIfAbsent(str, k -> new ArrayList<>()).add(Integer.parseInt(personInfo[4]));
            return;
        }
        generateCombinations(personInfo, str + "-", count + 1);
        generateCombinations(personInfo, str + personInfo[count], count + 1);
    }
}
