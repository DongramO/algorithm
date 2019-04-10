package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by idongsu on 2017. 9. 19..
 */
public class num_2240 {
    static public void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] k = in.readLine().split(" ");
        int T = Integer.parseInt(k[0]);
        int N = Integer.parseInt(k[1]);

        int[] berry = new int[T+1];
        int[][] dp = new int[T+1][N + 1];
        int cnt = 0;

        for (int i = 1; i < T+1; ++i) {
            berry[i] = Integer.parseInt(in.readLine());

            if(berry[i] == 1)
            {
                cnt++;
                dp[i][0] = cnt;
            }
            else
                dp[i][0] = cnt;
        }

        dp[1][1] = berry[1] == 2 ? 1 : 0;

        for(int i=2; i<T+1; ++i)
        {
            for(int j=1; j<N+1; ++j)
            {
                int plus;
                if(j >= T)
                    continue;
                if(j % 2 == 1)
                {
                    plus = berry[i] == 2 ? 1 : 0;
                }
                else
                    plus = berry[i] == 1 ? 1 : 0;

                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+ plus;
            }
        }

        int ans = 0;

        for (int m = 0; m <= N; m++)
            ans = Math.max(ans, dp[T][m]);

        System.out.print(ans);
    }
}