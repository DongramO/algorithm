package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_13398_2
{
    static public void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(in.readLine());

        long[] tree = new long[T + 1];
        long[] dp = new long[T+2];
        long[] dp2 = new long[T+2];
        long result =-1000;
        Arrays.fill(dp,-1000);
        Arrays.fill(dp2,-1000);

        st = new StringTokenizer(in.readLine(), " ");

        for (int i = 1; i < T + 1; i++)
        {
            tree[i] = Long.parseLong(st.nextToken());
        }


        for (int i = 1; i < T+1; i++)
        {
            dp[i] = tree[i];
            if (dp[i - 1] + tree[i] > tree[i])
            {
                dp[i] = dp[i-1]+tree[i];
            }
        }

        for (int i=T; i >0; i--)
        {
            dp2[i] = tree[i];
            if (dp2[i+1] + tree[i] > dp2[i])
            {
                dp2[i] = dp2[i+1]+tree[i];
            }
        }
        result = dp[1];

        for (int i=1; i<T+1; i++)
        {
            if (result < dp[i])
            {
                result = dp[i];
            }
        }
        for(int i=1; i< T+1; i++)
        {
            result = Math.max(result,dp[i-1]+dp2[i+1]);
        }
        System.out.print(result);
    }
}

