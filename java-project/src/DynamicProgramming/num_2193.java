package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by idongsu on 2017. 9. 12..
 */
public class num_2193 {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        long[] dp = new long[N+1];

        dp[1] = 1;
        if(N>1)
            dp[2] = 1;


        for(int i=3; i<N+1; i++)
        {
            dp[i] = dp[i-2]+dp[i-1];
        }

        System.out.print(dp[N]);
    }
}
