package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

/**
 * Created by idongsu on 2017. 7. 20..
 */
public class num_10844
{
    static public void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        long[][] dp = new long[N+1][11];

        long result = 0;
        for(int i=1; i<=10; i++)
        {
            dp[1][i] = 1;
        }
        for(int i=1;i<10;i++)
        {
             result += resolve(i,N,dp);
        }
//        resolve2(N,dp);
//            for (int j = 1; j < 10; j++)
//                result  += dp[N][j];


        System.out.print(result%1000000000);
    }

    static long resolve(int index,int n, long[][] dp)
    {

        if (dp[n][index] > 0)
        {
            return dp[n][index]%1000000000;
        }
        if (n == 1) return dp[n][index] = 1;

        if (index == 0)
        {
            long temp = resolve(index + 1, n - 1, dp);
            dp[n][index] = temp;
        }
        else if(index == 9)
        {
            long temp = resolve(index - 1, n - 1, dp);
            dp[n][index] = temp;
        }
        else
        {
            long temp = (resolve(index - 1, n - 1, dp) + resolve(index + 1, n - 1, dp));
            dp[n][index] = temp;
        }

        return dp[n][index] %= 1000000000;

    }

    //내 현재위치를 기준으로 이전 단계에서 가질 수 있는 경우의 수를 파악한다.
    static long[][] resolve2(int n, long[][]dp)
    {
        for(int i=2; i<=n;i++)
        {
            for (int j = 0; j < 10; j++)
            {
                if(j == 0)
                {
                    dp[i][j]  = dp[i-1][j+1];
                }
                else if(j == 9)
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = dp[i-1][j+1] + dp[i-1][j-1];
                }

                dp[i][j] = dp[i][j] % 1000000000;
            }
        }
        return dp;
    }
}
