package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by idongsu on 12/06/2019.
 */
public class boj_1389 {

    static int n; // 유저수
    static int m; // 친구관계
    static int[][] map;
    static boolean[] visit;
    static int[] r;
    static int min = Integer.MAX_VALUE;
    static int result = 0;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];


        for(int i=0; i<m; ++i) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        for(int i=1; i<=n; ++i) {
            int sum = 0;
            r = new int[n+1];
            visit = new boolean[n+1];

            bfs(i);

            for(int j=1; j<=n; ++j) {
                sum += r[j];
            }

            if(min > sum) {
                min = sum;
                result = i;
            }

        }
        System.out.println(result);
    }

    static void bfs(int index) {
        Queue<Dot> q = new LinkedList<>();

        q.add(new Dot(index, 0));
        visit[index] = true;

        while(!q.isEmpty()) {

            Dot d = q.poll();

            int start = d.a;
            int re = d.r+1;

            for(int i=1; i<=n; ++i) {

                if(d.a ==  i) continue;
                if(map[start][i] != 1) continue;
                if(visit[i] == true) continue;

                visit[i] = true;

                r[i] = re;
                q.add(new Dot(i, re));
            }
        }
    }

    static class Dot {
        int a,r;

        Dot(int a, int r) {
            this.a = a;
            this.r = r;
        }
    }
}
