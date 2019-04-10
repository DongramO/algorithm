package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by idongsu on 2017. 9. 12..
 */
public class num_11049 {
    static int[][] dp;
//    static int min = 0;
    static int[][] num;
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        num = new int[501][3];
        dp = new int[501][501];
        for(int i=0; i<501; i++)
            Arrays.fill(dp[i],-1);

        for(int i=1; i < n+1; ++i)
        {
            String[] element = in.readLine().split(" ");
            num[i][0] = Integer.parseInt(element[0]);
            num[i][1] = Integer.parseInt(element[1]);
        }
        System.out.print(cal(1,n));
    }

    static int cal(int x, int y)
    {
        if(x == y) return 0;

        if(dp[x][y] != -1) return dp[x][y];

        int min = Integer.MAX_VALUE;

        for(int k=x; k<y; ++k)
        {
            min = Math.min(min,cal(x,k)+cal(k+1,y)+ num[x][0]*num[k+1][0]*num[y][1]);
        }

        dp[x][y] = min;
        return min;
    }
}
