package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 07/06/2019.
 */
public class boj_2468 {
    static int n;
    static int[][] map;
    static int[][] visit;
    static int cnt;
    static int max = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visit = new int[n][n];

        for(int i=0; i<n; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int rain = 1;

        while(true) {

            visit = new int[n][n];

            int check = 0;

            for(int i=0; i<n; ++i) {
                for(int j=0; j<n; ++j) {
                    if(map[i][j] < rain) {
                        visit[i][j] = 1;
                        check++;
                    }
                }
            }

            if(check == n * n) break;

            cnt = 0;

            for(int i=0; i<n; ++i) {
                for(int j=0; j<n; ++j) {
                    if(visit[i][j] == 0) {
                        dfs(i,j);
                        cnt++;
                    }
                }
            }

            max = Math.max(max, cnt);
            rain++;
        }

        System.out.print(max);
    }

    static void dfs(int x, int y) {

        visit[x][y] = 1;

        for(int i=0; i<4; ++i) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] == 1) continue;


            dfs(nx, ny);

        }


    }
}
