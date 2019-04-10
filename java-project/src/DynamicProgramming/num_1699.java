package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by idongsu on 2017. 7. 27..
 */
public class num_1699
{
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] dp = new int[N+1];
        System.out.println(solve(N,dp));
//        System.out.print(Arrays.toString(dp));

    }

    public static int solve(int N, int[] dp)
    {
        for(int j=1;j<N+1;j++)
        {
            dp[j] = j;
            for (int i = 1; i * i <= j; i++)
            {
                if(dp[j] > dp[j-i*i]+1)
                {
                    dp[j] = dp[j-i*i]+1;
                }
            }
        }
        return dp[N];
    }
}
