package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 06/06/2019.
 */
public class boj_14499 {

    static int n,m,startx, starty, k;
    static int[][] map;
    static int[] dice; // 위, 북, 동, 서, 남, 바닥
    static int[] dir;
    static int[] dx = {0, 0,0,-1,1};
    static int[] dy = {0, 1,-1,0,0};


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        startx = Integer.parseInt(st.nextToken());
        starty = Integer.parseInt(st.nextToken());


        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dice = new int[6];
        dir = new int[k];

        for(int i=0; i<n; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<k; ++i) {
            dir[i] = Integer.parseInt(st.nextToken());
        }

        revolve(startx, starty, 0);

    }

    static void revolve(int x, int y, int depth) {

        if(depth == k) return;

        int d = dir[depth];
        int nx = x + dx[d];
        int ny = y + dy[d];

        if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
            revolve(x, y, depth+1);
            return;
        }

        int[] tdice = new int[6];
        for (int i = 0; i < 6; i++)  tdice[i] = dice[i];

        if(d == 1) {
            dice[0] = tdice[3];
            dice[2] = tdice[0];
            dice[3] = tdice[5];
            dice[5] = tdice[2];
        } else if( d == 2) {
            dice[0] = tdice[2];
            dice[2] = tdice[5];
            dice[3] = tdice[0];
            dice[5] = tdice[3];

        } else if ( d == 3) {
            dice[0] = tdice[4];
            dice[1] = tdice[0];
            dice[4] = tdice[5];
            dice[5] = tdice[1];
        } else if ( d == 4) {
            dice[0] = tdice[1];
            dice[1] = tdice[5];
            dice[4] = tdice[0];
            dice[5] = tdice[4];
        }
        check(nx, ny);

        System.out.println(dice[0]);
        revolve(nx, ny, depth+1);
    }

    static void check(int nx, int ny) {

        int current = map[nx][ny];

        if( current ==  0) {
            map[nx][ny] = dice[5];
        } else{
            dice[5] = current;
            map[nx][ny] = 0;
        }

    }
}


