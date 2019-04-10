package algo;

import java.util.Scanner;

public class n_queen {

    static int row[];
    static int n;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            // 첫번째 퀸의 시작점은 열을 기준. (i = 1) => (1, 1), (i = 2) => (1, 2), (i = 3) => (1, 3)
            row = new int[16];
            row[1] = i;

            // 1. DFS 수행 (다음 행인 2열 이동)
            dfs(2);
        }

        // 정답 출력
        System.out.println(ans);
    }

    static void dfs(int col) {
        // 현재 열이 체스판을 넘어 섰으면
        if (col > n) {
            ++ans;
        } else {
            for (int i = 1; i <= n; i++) {
                // 현재 위치하고 있는 노드의 좌표를 저장 (col: 열, i: 행)
                row[col] = i;

                // 2. 유망한 노드 검토
                if (isPossible(col)) {
                    // 3. 서브 트리 이동 (해당 노드의 하위 노드)
                    dfs(col + 1);
                } else {
                    // 4. 백트래킹 수행, 해당노드는 가지치기 되어진다.
                    row[col] = 0;
                }
            }
        }
    }

    static boolean isPossible(int c) {
        // 이전 열들을 탐색하면서 유망한 노드인지 확인
        for (int i = 1; i < c; i++) {
            // 상위 노드에서 같은 행에 퀸이 있는지 여부
            if (row[i] == row[c]) {
                return false;
            }
            // 대각선 검사, 상위 노드의 퀸과 현재 노드의 퀸의 가로 세로 거리가 같은지 검사
            if (Math.abs(row[i] - row[c]) == Math.abs(i - c)) {
                return false;
            }
        }
        return true;
    }
}