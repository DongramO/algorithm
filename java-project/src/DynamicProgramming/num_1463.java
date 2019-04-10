package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_1463
{
    static public void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        int[] dp = new int[T+1];

        System.out.print(resolve(T,dp));

    }
    static int resolve(int n,int[] dp)
    {
        if( n == 1) return 0;
        if (dp[n] > 0)
        {
            return dp[n];
        }
        dp[n] = resolve(n-1,dp)+1;

        if(n%3 == 0)
        {
           Math.min(dp[n],resolve(n/3,dp)+1);
        }
        if(n%2 == 0)
        {
            Math.min(dp[n],resolve(n/2,dp)+1);
        }
        return dp[n];
    }
}
