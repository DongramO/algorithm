package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_13398
{
    static public void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(in.readLine());

        long[] tree = new long[T + 1];
        long[] dp = new long[T + 1];
        long[] dp2 = new long[T+1];
        Arrays.fill(dp,-1000);
        Arrays.fill(dp2,-1000);
        st = new StringTokenizer(in.readLine(), " ");

        for (int i = 1; i < T + 1; i++)
        {
            tree[i] = Long.parseLong(st.nextToken());
        }

        long result =-1000;
        for(int i = 1 ;i < T+1;i++)
        {
            System.out.println(i);
            if(dp[i-1]+tree[i]> tree[i])
            {
                dp[i] = dp[i-1]+tree[i];
            }
            else
            {
                dp[i] = tree[i];
            }
            dp2[i] = Math.max(dp[i-1], Math.max(dp[i-1]+tree[i], dp2[i-1]+tree[i]));
            result = Math.max(result,dp2[i]);

        }

        System.out.print(result);
    }
}

