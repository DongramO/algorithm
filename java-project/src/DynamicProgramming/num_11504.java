package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_11504 {
    static public void main(String args[]) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k  = Integer.parseInt(in.readLine());
        int[] arr = new int[k+1];
        int[] dp = new int[k+1];
        int[] dp2 = new int[k+1];
        Arrays.fill(dp,1);
        Arrays.fill(dp2,1);
        int total = 0;
        st = new StringTokenizer(in.readLine());

        for(int i=1; i<k+1; ++i)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<k+1; ++i)
        {
            for(int j=1; j<i; ++j)
            {
                if(arr[j] < arr[i] && dp[j] >= dp[i])
                {
                    dp[i] = dp[j]+1;
                }
            }

            for (int m = k; m >k-i; m--)
            {
                if (arr[k-i] > arr[m] && dp2[k-i] <= dp2[m])
                {
                    dp2[k -i] = dp2[m] + 1;
                }
            }
        }

        for(int i=0; i<k+1;i++)
            total = Math.max(total,dp[i]+dp2[i]);

        System.out.print(total-1);
    }
}
