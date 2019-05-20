package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by idongsu on 03/04/2019.
 */
public class boj_4963 {

    static int[][] result;
    static int[][] arr;
    static int row;
    static int col;
    static int cnt;

    // 상하좌우, 대각선 4방향
    static int[] dx = {0,0,1,-1,-1,-1,1,1};
    static int[] dy = {1,-1,0,0,-1,1,-1,1};

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        while(true) {

            col = sc.nextInt();
            row = sc.nextInt();
            cnt = 0;

            if(col == 0 && row == 0) break;

            result = new int[row][col];
            arr = new int[row][col];

            for(int i=0; i < row; ++i) {
                for(int j=0; j< col; ++j) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for(int i=0; i < row; ++i) {
                for(int j=0; j < col; ++j) {
                    if(arr[i][j] == 0 || result[i][j] == 1) continue;
                    else {
                        dfs(arr, i, j, result);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void dfs(int[][] arr, int r, int c, int[][] result) {

        if(r >= row || c >= col || r < 0 || c < 0) return;
        if(arr[r][c] == 0 || result[r][c] == 1 ) return;

        result[r][c] = 1;

        for(int i : dx) {
            for(int j : dy) {
                dfs(arr, i, j, result);
            }
        }
    }
}
