package UnionFind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 2017. 10. 15..
 */
public class num_1717 {

    static int[] parent;
    static public void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = br.readLine().split(" ");

        int n = Integer.parseInt(mn[0]);
        int m = Integer.parseInt(mn[1]);
        int[][] map = new int[m+1][4];
        StringTokenizer st;
        parent = new int[n+1];

        for(int i=0; i<n+1; ++i)
            parent[i] = i;

        for(int i=1; i<m+1; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=3; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<m+1; ++i)
        {
            int max = Math.max(map[i][2],map[i][3]);
            int min = Math.min(map[i][2],map[i][3]);
            if(map[i][1] == 0) {
                union(min, max );
            }
            else {
                int a = find(map[i][2]);

                if(a != find(map[i][3]))
                {
                    System.out.println("NO");
                    continue;
                }
                System.out.println("YES");
            }
        }
    }

    static int find(int x)
    {
        if(parent[x] == x) return x;
        else
            return parent[x] = find(parent[x]);
    }
    static void union(int x, int y)
    {
        x = find(x);
        y = find(y);
        parent[x] = y;
    }
}
