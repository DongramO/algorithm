package DynamicProgramming;

import java.util.Scanner;

public class handshaking {

    static long[] dp;
    static int N;
    static public void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        dp = new long[N+1];

        if(N == 2){
            System.out.print(1);
        }
        else if(N == 4){
            System.out.print(2);
        }
        else {
            dp[0] = 1;
            dp[2] = 1;
            dp[4] = 2;
            for(int i = 6; i<N+1; i +=2)
            {
                for(int j=0; j<i-2+1; j+=2) {
                    dp[i] += dp[j] * dp[i-j-2];
                }
            }
            System.out.print(dp[N]);
        }
    }
}
