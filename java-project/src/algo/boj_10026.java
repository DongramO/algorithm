package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by idongsu on 07/06/2019.
 */
public class boj_10026 {

    static int k;
    static String[][] a;
    static String[][] b;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] visit;
    static int cntA = 0;
    static int cntB = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        k = Integer.parseInt(br.readLine());

        a = new String[k][k];
        b = new String[k][k];



        String[] str;
        // init arrays
        for(int i=0; i < k; ++i) {
             str = br.readLine().split("");

            for (int j = 0; j < str.length; ++j) {

                a[i][j] = str[j];

                if (str[j].equals("R")) {
                    b[i][j] = "G";
                } else {
                    b[i][j] = str[j];
                }
            }
        }

        visit = new int[k][k];

        for(int i=0; i < k; ++i) {
            for (int j = 0; j < k; ++j) {
                if(visit[i][j] == 0) {
                    dfs(i,j, a);
                    cntA++;
                }
            }
        }

        visit = new int[k][k];
        for(int i=0; i < k; ++i) {
            for (int j = 0; j < k; ++j) {
                if(visit[i][j] == 0) {
                    dfs(i,j, b);
                    cntB++;
                }
            }
        }

        System.out.print(cntA + " "+ cntB);
    }

    static void dfs(int x, int y, String[][] arr) {

        String color =  arr[x][y];
        visit[x][y] = 1;

        for(int i=0; i<4; i++ ) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= k || ny < 0 || ny >= k || visit[nx][ny] == 1) continue;

            if(!color.equals(arr[nx][ny])) continue;

            dfs(nx,ny, arr);

        }

    }
}
