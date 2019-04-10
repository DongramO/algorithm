package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

/**
 * Created by idongsu on 2017. 7. 21..
 */
public class num_11727
{
    static public void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        long[] dp = new long[N+1];

        System.out.println(solve(N,dp)%10007);
    }

    static long solve( int N, long[] dp)
    {
        if(dp[N] > 0)
        {
            return dp[N];
        }
        if(N == 0 )
        {
            return 1;
        }
        if(N >= 2)
        {
            long temp = solve(N-2,dp) * 2 + solve(N-1, dp);
            dp[N] += temp%10007;
        }
        else
        {
            long temp = solve(N-1,dp);
            dp[N] += temp%10007;
        }

        return dp[N];

    }
}
