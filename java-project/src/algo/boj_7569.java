package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 07/06/2019.
 */
public class boj_7569 {

    static int result;
    static int[][][] map;
    static int m,n,h;
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static int cnt = 0;
    static Queue<Dot> q;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][n][m];
        q = new LinkedList<>();

        for(int l=0; l<h; l++) {
            for(int i=0; i<n; ++i) {

                st = new StringTokenizer(br.readLine());

                for(int j =0; j<m; ++j) {
                    int v = Integer.parseInt(st.nextToken());

                    if(v == 0) cnt++;

                    if(v == 1) {
                        q.add(new Dot(l,i,j));
                    }

                    map[l][i][j] =  v;
                }
            }
        }

        if(cnt == 0) {
            System.out.println(0);
            return;
        }


        else {
            cnt = 0;
            while(!q.isEmpty()) {

                int k = q.size();
                for(int i=0; i<k; ++i) {
                    bfs();
                }

                cnt++;
            }
        }


        for(int l=0; l<h; l++){
            for(int i=0; i<n; ++i) {
                for(int j =0; j<m; ++j) {
                    if(map[l][i][j] == 0) {
                        System.out.print(-1); return;
                    }
                }
            }
        }

        System.out.println(cnt-1);
    }

    static void bfs() {

        Dot t = q.poll();

        for(int i=0; i<6; ++i) {

            int nx = t.x + dx[i];
            int ny = t.y + dy[i];
            int nz = t.z + dz[i];

            if(nz < 0 || nz >= h || nx < 0 || nx >= n || ny < 0 || ny >=m) continue;
            if(map[nz][nx][ny] == -1) continue;

            if(map[nz][nx][ny] == 0) {
                map[nz][nx][ny] = 1;
                q.add(new Dot(nz, nx, ny));
            }
        }
    }





    static class Dot {
        int x,y,z;

        Dot(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
