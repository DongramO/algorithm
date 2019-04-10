package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

/**
 * Created by idongsu on 2017. 7. 21..
 */
public class num_9095
{
    static public void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(in.readLine());

        for(int i =1; i<= test; i++)
        {
            long result =0;
            int N = Integer.parseInt(in.readLine());
            if(N ==1) System.out.println("1");
            else if(N <11)
            {
                long[] dp = new long[N + 1];
                result += solve(N, dp);
                System.out.println(result);
            }
        }

    }

    static long solve( int N, long[] dp)
    {
        if(N == 0 ) return 1;
        if(N < 0) return 0;
        if(dp[N] > 0)
        {
            return dp[N];
        }
        long temp = solve(N-2,dp) + solve(N-1, dp)+ solve(N-3,dp);
        dp[N]= temp;
        return dp[N];
    }
}
