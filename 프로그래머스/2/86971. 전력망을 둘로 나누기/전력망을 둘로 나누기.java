import java.util.*;

class Solution {

    private int n; // 노드의 개수
    private int[][] wires; // 연결된 선의 정보

    private List<Integer>[] adList; // 인접 리스트
    private boolean[] visited; // 방문 여부를 나타내는 배열
    private int min = Integer.MAX_VALUE; // 결과값을 저장할 변수

    public int solution(int n, int[][] wires) {
        this.n = n;
        this.wires = wires;

        initGraph(); // 그래프 초기화

        for (int i = 0; i < wires.length; i++) {
            int n1 = wires[i][0];
            int n2 = wires[i][1];

            disconnect(n1, n2); // 해당 선 연결 해제
            int cnt = dfs(1); // DFS 탐색 수행
            connect(n1, n2); // 해당 선 연결 복원

            int diff = Math.abs(cnt - (n - cnt)); // 현재 상태에서의 차이값 계산
            min = Math.min(min, diff); // 최소 차이값 갱신
        }

        return min; // 최종 결과 반환
    }

    // 그래프 초기화 메서드
    private void initGraph() {
        adList = new ArrayList[n + 1]; // 노드 개수만큼의 크기로 인접 리스트 배열 생성
        for (int i = 1; i <= n; i++) {
            adList[i] = new ArrayList<>(); // 각 노드의 인접 리스트 초기화
        }

        // 주어진 선의 정보를 이용하여 각 노드의 인접 리스트 구성
        for (int[] wire : wires) {
            int n1 = wire[0];
            int n2 = wire[1];
            adList[n1].add(n2);
            adList[n2].add(n1);
        }
    }

    // 해당 선 연결 해제 메서드
    private void disconnect(int n1, int n2) {
        adList[n1].remove(Integer.valueOf(n2)); // 노드 n1의 인접 리스트에서 n2 제거
        adList[n2].remove(Integer.valueOf(n1)); // 노드 n2의 인접 리스트에서 n1 제거
    }

    // 해당 선 연결 복원 메서드
    private void connect(int n1, int n2) {
        adList[n1].add(n2); // 노드 n1의 인접 리스트에 n2 추가
        adList[n2].add(n1); // 노드 n2의 인접 리스트에 n1 추가
    }

    // DFS 수행 메서드
    private int dfs(int v) {
        visited = new boolean[n + 1]; // 방문 여부 배열 초기화
        return dfsHelper(v, 1); // DFS 수행 시작
    }

    // DFS 수행을 위한 도우미 메서드
    private int dfsHelper(int v, int cnt) {
        visited[v] = true; // 현재 노드 방문 표시
        for (int next : adList[v]) {
            if (!visited[next]) {
                cnt = dfsHelper(next, cnt + 1); // 재귀적으로 DFS 수행
            }
        }
        return cnt; // DFS 탐색을 통해 얻은 노드 개수 반환
    }
}
