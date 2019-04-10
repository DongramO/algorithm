package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class num_2225
{
    static public void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] insert = in.readLine().split(" ");
        int N = Integer.parseInt(insert[0]);
        int K = Integer.parseInt(insert[1]);
        long[][] dp = new long[201][201];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 3;

        if (K == 1) System.out.println(1);
        else if (K > N) System.out.println(0);
        else if (K == N) System.out.println(1);
        else
        {
            for (int i = 3; i < N + 1; i++)
            {
                for (int j = 1; j < K+1; j++)
                {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j])%1000000000;
                }
            }
        }
        for (int i = 1; i < N + 1; i++)
        {
            for (int j = 1; j < K+1; j++)
            {
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println(" ");
        }
    }
}

