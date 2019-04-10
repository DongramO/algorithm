package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by idongsu on 2017. 7. 22..
 */
public class num_11057
{
    static public void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        long[][] dp = new long[N+1][10];
        long result = 0;
        for(int i=0; i<10;i++)
        {
            dp[1][i] = 1;
        }
        if(N ==1) System.out.print("10");
        else
        {
            for (int i = 2; i <=N; i++)
            {
                int sum = 0;

                for (int j = 0; j < 10; j++)
                {
                    result = 0;
                    for (int k = j; k < 10; k++)
                    {
                       result += dp[i - 1][k];

                    }
                    dp[i][j] = result%10007;
                }
            }

            result = 0;
            for(int i=0;i<10;i++)
            {
                result += dp[N][i];
            }
            System.out.print(result%10007);
        }
    }
}
