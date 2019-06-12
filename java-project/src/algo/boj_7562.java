package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 12/06/2019.
 */
public class boj_7562 {

    static int t;
    static int n;
    static boolean[][] visit;
    static Dot start, des;
    static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dy = { -2, -1, 1, 2, -2, -1, 1, 2 };
    static int cnt = 1;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        for(int i=0; i<t; i++) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            visit = new boolean[n][n];

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            start = new Dot(x, y, 0);

            st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());
            des = new Dot(dx, dy, 0 );


            int result = bfs(start, des, cnt);

            System.out.println(result);

        }
    }


    static int bfs(Dot start, Dot des, int cnt) {

        Queue<Dot> q = new LinkedList<>();

        q.add(start);


        while(!q.isEmpty()) {

            Dot d = q.poll();

            visit[d.x][d.y] = true;

            if(d.x == des.x && d.y == des.y) return d.cnt;


            // 여덟 방향으로 돌림
            for(int i=0; i < 8; ++i) {

                int nx = d.x + dx[i];
                int ny = d.y + dy[i];
                int m = d.cnt+1;

                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(visit[nx][ny] == true) continue;

                visit[nx][ny] = true;
                q.add(new Dot(nx, ny, m));
                if(nx == des.x && ny == des.y) return m;
            }
        }
        return -1;
    }


    static class Dot {

        int x, y, cnt;

        Dot(int x, int y, int cnt) {

            this.x = x;
            this.y = y;
            this.cnt = cnt;

        }
    }
}
