package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by idongsu on 2017. 9. 20..
 */
public class num_2240_1 {
    static public void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int w = in.nextInt();
        int[][][] dp = new int[3][1001][32];
        int[] arr = new int[t+1];

        for(int i=1; i<t+1; ++i)
        {
            arr[i] = in.nextInt();
        }


        for(int i=1; i<t+1; ++i)
        {
            for(int j=1; j<=w+1; ++j)
            {
                if(arr[i] == 1)
                {
                    dp[1][i][j] = Math.max(dp[1][i-1][j]+1, dp[2][i-1][j-1]+1);
                    dp[2][i][j] = Math.max(dp[2][i-1][j], dp[1][i-1][j-1]);
                }
                else
                {
                    dp[1][i][j] = Math.max(dp[1][i-1][j], dp[2][i-1][j-1]);
                    dp[2][i][j] = Math.max(dp[2][i-1][j]+1, dp[1][i-1][j-1]+1);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= w + 1; i++) {
            ans = Math.max(ans, Math.max(dp[1][t][i], dp[2][t][i]));
        }

        System.out.println(ans);
    }
}
