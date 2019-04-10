package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 2017. 7. 27..
 */
public class num_2579
{
    static public void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(in.readLine());
        int[] arr = new int[T + 1];
        int[][] dp = new int[T+1][3];
        long result = 0;
        for(int i=1; i < T+1; i++)
        {
            arr[i] = Integer.parseInt(in.readLine());
        }

        dp[1][1] = arr[1];
        dp[1][2] = arr[1];
        for(int i=2; i < T+1; i++)
        {
            dp[i][2] = dp[i-1][1]+arr[i];
            dp[i][1] = Math.max(dp[i-2][1],dp[i-2][2])+arr[i];
        }

        System.out.println(Math.max(dp[T][1],dp[T][2]));

//        for(int i=1; i <T+1;i++)
//        {
//            for (int j = 1; j < 3; j++)
//                System.out.print(dp[i][j] + " ");
//            System.out.println(" ");
//        }
    }
}
