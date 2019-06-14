package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2644 {

    static int n;
    static int m;
    static int[][] map;
    static int start;
    static int end;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<m; ++i) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향 그래프
            map[a][b] = 1;
            map[b][a] = 1;
        }

        System.out.print(bfs(start, end));
    }

    static int bfs(int start, int end) {

        Queue<Dot> q = new LinkedList<>();

        q.add(new Dot(start, 0));

        map[start][0] = -1;

        while(!q.isEmpty()) {

            Dot dot = q.poll();
            int r = dot.r + 1;

            for(int i=1; i<=n; ++i) {

                if(map[dot.a][i] == 0) continue;
                if(map[i][0] == -1) continue;

                map[i][0] = -1;

                if(i == end) return r;

                q.add(new Dot(i,r));
            }

        }

        return -1;
    }

    static class Dot {
        int a;
        int r;

        Dot(int a, int r) {
            this.a = a;
            this.r = r;
        }
    }
}
