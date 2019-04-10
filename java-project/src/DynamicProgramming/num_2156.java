package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 2017. 7. 27..
 */
public class num_2156
{
    static public void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st;

        long[][] dp = new long[N+1][3];
        long[] arr = new long[N+1];
        for(int i=1; i< N+1; i++ )
        {
            arr[i] = Long.parseLong(in.readLine());
        }

        for(int i=1; i<N+1; i++)
        {
            dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2])); // i를 마시지 않음
            dp[i][1] = arr[i] + dp[i-1][0]; // i-1을 마시지 않음
            dp[i][2] = arr[i] + dp[i-1][1]; // i-1은 마시고 i-2는 마시지 않음
        }

        for(int i=1; i< N+1; i++ )
        {
            for(int j=0;j<3;j++)
            System.out.print(dp[i][j]+"\t");
            System.out.println("");
        }

        System.out.print(Math.max(dp[N][0],Math.max(dp[N][1],dp[N][2])));
    }
}
