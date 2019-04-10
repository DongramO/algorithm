package algo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by idongsu on 13/03/2019.
 */

public class boj_9663 {
    static int N;
    static int ans;

    public static void main(String args[]) {
        // 배열 크기의 범위는 1 <= N <= 15
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        ans = 0;
        int[] col = new int[N];

        Arrays.fill(col, -1);

        for(int i = 0; i < N; ++i) {
            col[0] = i;
            dfs_recursive(col, 1);
        }

        System.out.print(ans);
    }

    public static void dfs_recursive(int[] col, int v) {

        if(v > N-1) {
            ++ans;
        } else {
            for(int i = 0; i < N; ++i) {
                col[v] = i;
                if(promising(col, v)) {
                    dfs_recursive(col, v+1);
                } else {
                    col[v] = -1;
                }
            }
        }
    }


    // 탐색에 대하여 더 이상 진행할 것인가에 대한 판별
    public static boolean promising(int[] col, int v) {
        for(int i = 0; i < v; ++i) {
            // 두개의 말이 같은 열에 있는 경우
            if(col[i] == col[v]) return false;

            // 두개의 말이 같은 대각선에 있는 경우
            if(Math.abs(col[i] - col[v]) == Math.abs(i-v)) return false;
        }
        return true;
    }
}
