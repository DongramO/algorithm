package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 14/06/2019.
 */
public class boj_1012 {

    static int t;
    static int r,c,n;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int cnt = 0;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        int index = 0;

        while(index < t) {

            st = new StringTokenizer(br.readLine());

            c = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            map = new int[r][c];
            visit = new boolean[r][c];

            for(int i=0; i<n; ++i) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[b][a] = 1;
            }

            cnt = 0;

            for(int i=0; i<r; ++i) {
                for(int j=0; j<c; ++j) {
                    if(map[i][j] == 1 && !visit[i][j]) {
                        bfs(i,j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
            index++;
        }
    }


    static void bfs(int x, int y) {
        Queue<Dot> q = new LinkedList<>();

        visit[x][y] = true;

        q.add(new Dot(x, y));


        while(!q.isEmpty()) {

            Dot t = q.poll();

            for(int i=0; i<4; ++i) {

                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if(nx < 0 || nx >= r || ny < 0 || ny >=c) continue;
                if(visit[nx][ny] || map[nx][ny] != 1) continue;

                visit[nx][ny] = true;

                q.add(new Dot(nx, ny));
            }
        }
    }


    static class Dot{

        int x;
        int y;

        Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
