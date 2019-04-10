package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1987 {

    static char[][] arr;
    static int r;
    static int c;
    static int ans;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] m = br.readLine().split(" ");

        r = Integer.parseInt(m[0]);
        c = Integer.parseInt(m[1]);

        arr = new char[r][c];
        int[] visit = new int[50];
        String k = "";

        for(int i=0; i <r; ++i) {
            k = br.readLine();
            for(int j=0; j<c; ++j) {
                arr[i][j] = k.charAt(j);
            }
        }

        System.out.print(dfs(0, 0, visit, 0));
    }

    public static int dfs(int x, int y, int[] visit, int ans) {

        // 범위 초과 일때,
        if(x>=r || x<0 || y >=c || y <0) return ans;

        int t = (int)arr[x][y]-65;
        if(visit[t] == 1) return ans;

        visit[t] = 1;

        // 상하 좌우 탐색
        int 하 = dfs(x+1, y, visit, ans+1);
        int 우 = dfs(x, y+1, visit, ans+1);
        int 상 = dfs(x-1, y, visit, ans+1);
        int 좌 = dfs(x, y-1, visit, ans+1);

        visit[t] = 0;

        ans = Math.max(상, Math.max(Math.max(하, 좌), 우));

        return ans;
    }
}
