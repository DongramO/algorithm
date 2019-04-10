package DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_11722 {
    static public void main(String args[]) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k = Integer.parseInt(in.readLine());

        int[] arr = new int[k+1];
        int[] dp = new int[k+1];
        Arrays.fill(dp,1);
        st = new StringTokenizer(in.readLine());
        for(int i=1; i<k+1; ++i)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result =0;

        for(int i=1; i<k+1; ++i)
        {
            for(int j=0; j<i; ++j)
            {
                if(arr[j] > arr[i] && dp[j] >= dp[i])
                {
                    dp[i] = dp[j]+1;
                }
            }
            result = Math.max(result,dp[i]);
        }

        System.out.print(result);

    }
}
