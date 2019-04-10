package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_1965 {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        st = new StringTokenizer(in.readLine()," ");

        for(int j=1; j<n+1; j++)
        {
            arr[j] = Integer.parseInt(st.nextToken());
            dp[j] = 1;
        }

        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<=i;j++)
            {
                // LIS
                if(arr[j] < arr[i] && dp[i] < dp[j]+1)
                    dp[i] = dp[j] +1;
            }
        }

        int result=0;
        for(int i=1; i<n+1;i++)
        {
            result = Math.max(result,dp[i]);
        }
        System.out.print(result);
    }
}
