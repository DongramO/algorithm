package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num_9465
{
    static public void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for(int i=0; i<T ; i++)
        {
            int N = Integer.parseInt(in.readLine());
            long [][] init = new long[3][N+1];
            long[][] dp = new long[2][N+1];
            for(int j =1; j<3;j++)
            {
                String[] line = in.readLine().split(" ");
                for(int k=1; k<N+1;k++)
                {
                    init[j][k] = Long.parseLong(line[k-1]);
                }
            }

            dp[0][0] = 0;
            dp[1][0] = 0;

            dp[0][1] = init[1][1];
            dp[1][1] = init[2][1];

            for(int m=2; m< N+1; m++)
            {
              dp[0][m] = Math.max(dp[1][m-2],dp[1][m-1])+ init[1][m];
              dp[1][m] = Math.max(dp[0][m-2],dp[0][m-1])+ init[2][m];
            }
           System.out.println(Math.max(dp[0][N],dp[1][N]));
        }
    }
}
