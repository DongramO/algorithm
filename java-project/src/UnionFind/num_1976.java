package UnionFind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_1976 {

    static int[] parent;
    static public void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        StringTokenizer st;
        int[][] map = new int[n + 1][n + 1];
        parent = new int[n+1];

        for (int i = 1; i < n+1; ++i) {
            st = new StringTokenizer(in.readLine());
            parent[i] = i;
            for (int j = 1; j < n+1; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n+1; ++i) {
            for (int j = 1; j < n+1; ++j) {
                if(map[i][j] == 1)
                    unite(i,j);
            }
        }

        st = new StringTokenizer(in.readLine());
        int b = find(Integer.parseInt(st.nextToken()));

        for (int t = 2; t < m+1; t++) {
            if (b != find(Integer.parseInt(st.nextToken()))) {
                System.out.print("NO");
                break;
            }
        }
        System.out.print("YES");


    }

    static int find(int x)
    {
        if( x == parent[x])
            return x;
        // 부모의 부모가 누군지 계속 찾아 올라가는 엘스문
        else
            return parent[x] = find(parent[x]);
    }


    // 루트를 변경 시켜 준다.
    static void unite(int x, int y)
    {
        x = find(x);
        y = find(y);
        parent[x] = y;
    }


}

