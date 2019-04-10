package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by idongsu on 2017. 7. 21..
 */
public class num_11052
{
    static public void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] price = new int[N+1];
        int[] dp = new int[N+1];
        String[] val  = in.readLine().split(" ");
        for(int i=1; i<=N; i++)
        {
            price[i]  = Integer.parseInt(val[i-1]);
        }

        for(int i=1; i <=N ; i++)
        {
            for(int j=1; j<=i; j++)
            {
                dp[i] = Math.max(dp[i], dp[i-j] + price[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
