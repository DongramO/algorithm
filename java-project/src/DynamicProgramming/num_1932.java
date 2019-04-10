package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 2017. 7. 24..
 */

public class num_1932 {
    static public void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(in.readLine());

        long[][] tree = new long[T+1][T+1];
        long[][] dp = new long[T+1][T+1];
        for(int i=1;i<T+1;i++)
        {
            st = new StringTokenizer(in.readLine()," ");
            for(int j=1;j<i+1;j++)
                tree[i][j] = Integer.parseInt(st.nextToken());
        }

        dp[1][1] = tree[1][1];
        for(int i=2; i<T+1; i++)
        {
            for(int j=1;j<=i;j++)
            {
                dp[i][j] = Math.max(dp[i - 1][j-1], dp[i-1][j])+ tree[i][j];
            }
        }

        Arrays.sort(dp[T]);
        System.out.print(dp[T][T]);
    }
}
