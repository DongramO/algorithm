package algo;

/*

 눈금의 간격이 1인 M*N의 모눈종이가 있다.
 눈금에 맞추어 K개의 직사각형을 그릴 때 k개의 직사각형의 내부를 제외한 나머지 부분이 영역이 나뉜다.

 M,N 그리고 K 개의 직사각형의 좌표가 주어질 때,
 K개의 직사각형 내부를 제외한 나머지 부분과 영역의 넓이를 구하라.

*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_2583 {

    public static int m,n,k;
    public static int[][] map;
    public static ArrayList<Integer> list;
    public static int[] dx = {-1,0,0,1};
    public static int[] dy = {0,1,-1,0};
    public static int[][] visit;
    static int cnt;
    static int result;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n];

        list = new ArrayList<>();


        for(int i=0; i<k; i++) {

            String[] str = br.readLine().split(" ");

            int x1 = Integer.parseInt(str[0]);
            int y1 = Integer.parseInt(str[1]);
            int x2 = Integer.parseInt(str[2]);
            int y2 = Integer.parseInt(str[3]);

            for(int q=m-y2; q <m-y1; q++) {
                for(int w=x1; w<x2; w++) {
                    map[q][w] = 1;
                }
            }
        }

        cnt = 0;
        for(int i=0; i<m; i++) {

            for(int j=0; j<n; j++) {

                if(map[i][j] == 0)  {
                    visit = new int[m][n];
                    result = 1;
                    dfs(i,j);
                    list.add(result);
                    cnt++;
                }
            }
        }

        Collections.sort(list);

        System.out.println(cnt);

        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i)+ " ");
        }

    }

    // 재귀!
    static void dfs(int x, int y) {

        map[x][y] = 2;

        for(int i=0; i<4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배열 범위 초과일 때

            if(nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }

            if(map[nx][ny] != 0) {
                continue;
            }


            dfs(nx, ny);
            result++;
        }
    }

}


