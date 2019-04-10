package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num_5557 {
    static int T;
    static int count =0;
    static long[][] dp;
    static int[][] num3;
    static int[] num2;
    static public void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(in.readLine());

        String[] num = new String[T];
        num = in.readLine().split(" ");
        num2 = new int[T+1];
        dp = new long[T+1][21];
        num3 = new int[T-1][2];


        for (int i = 1; i < T + 1; ++i) {
            num2[i] = Integer.parseInt(num[i-1]);
            Arrays.fill(dp[i],-1);
        }

        long ans = 0;
        solve(1,num2[1]);

        for(int i=1; i<T; i++)
          for(int j=0; j<21; ++j)
              ans = Math.max(ans,dp[i][j]);

        System.out.print(ans);

    }
    static long solve(int i,int j)
    {
        if(dp[i][j] != -1) return dp[i][j];

        if(j > 20 || j < 0 || i>T-1)
            return 0;

        if(i == T-1 && j == num2[T])
            return 1;


        dp[i][j] = solve(i+1,j+num2[i+1])+ solve(i+1, j-num2[i+1]);

        return dp[i][j];
    }
}

