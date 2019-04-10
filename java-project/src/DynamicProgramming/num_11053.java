package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 2017. 7. 26..
 */
public class num_11053
{
    static public void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        int max =0;
        st = new StringTokenizer(in.readLine());
        int last=0;

        for(int i=1; i<N+1; i++) arr[i] = Integer.parseInt(st.nextToken());
        for(int i=1; i<N+1; i++)
        {
            dp[i] =1;
            last = 0;
            for (int j = 1; j < i; j++)
            {
                if(arr[i] > arr[j] && dp[j]+1 > dp[i])
                {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max,dp[i]);
        }
        System.out.print(max);
    }
}
