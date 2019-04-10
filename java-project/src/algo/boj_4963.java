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
                    if(arr[i][j] == 0 || result[i][j] == 1)  {
                        continue;
                    }
                    else {
//                        System.out.println("i : "+ i + " j :"+ j);
                        dfs(arr, i, j, result);

//                        for(int m=0; m<row; ++m) {
//                            for(int n=0; n<col; ++n) {
//                                System.out.print(result[m][n]);
//                            }
//                            System.out.println();
//                        }

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

        dfs(arr, r+1, c, result);
        dfs(arr, r, c+1, result);
        dfs(arr, r-1, c, result);
        dfs(arr, r, c-1, result);

        dfs(arr, r+1, c+1, result);
        dfs(arr, r-1, c-1, result);
        dfs(arr, r+1, c-1, result);
        dfs(arr, r-1, c+1, result);

    }
}
