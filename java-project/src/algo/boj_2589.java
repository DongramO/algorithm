package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2589 {

    static String[][] map;
    static boolean[][] visit;
    static int r,c;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new String[r][c];

        for(int i=0; i<r; ++i) {
            String[] t = br.readLine().split("");
            for(int j=0; j<c; ++j) {
                map[i][j] = t[j];
            }
        }

        for(int i=0; i<r; ++i) {

            for(int j=0; j<c; ++j) {
                visit = new boolean[r][c];
                if(map[i][j].equals("L"))  bfs(new Dot(i,j,0));
            }
        }

        System.out.print(max-1);

    }

    static void bfs(Dot d) {

        Queue<Dot> q = new LinkedList<>();

        visit[d.x][d.y] = true;

        q.add(d);

        while(!q.isEmpty()) {

            Dot nd = q.poll();

            int nx = 0, ny = 0, nr = 0;

            for(int i=0; i<4; ++i) {

                nx = nd.x + dx[i];
                ny = nd.y + dy[i];
                nr = nd.r + 1;

                if(nx < 0 || nx >=r || ny < 0 || ny >=c ) continue;
                if(visit[nx][ny] == true) continue;
                if(map[nx][ny].equals("W")) continue;

                visit[nx][ny] = true;

                q.add(new Dot(nx,ny,nr));
            }

            max = Math.max(max, nr);

        }

    }


    static class Dot {
        int x;
        int y;
        int r;

        Dot(int x, int y, int r) {

            this.x = x;
            this.y = y;
            this.r = r;

        }
    }
}
