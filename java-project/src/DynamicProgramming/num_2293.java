package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by idongsu on 2017. 9. 11..
 */
public class num_2293
{
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] k = in.readLine().split(" ");
        int kind = Integer.parseInt(k[0]);
        int size = Integer.parseInt(k[1]);

        int[] coin = new int[kind];
        int[] dp = new int[size+1];

        for(int i=0; i<kind; ++i) {
            coin[i] = Integer.parseInt(in.readLine());
        }
        Arrays.fill(dp,-1);
        dp[0] = 0;

        for(int i=0; i<kind; ++i)
        {
            for(int j=1; j<=size; ++j)
            {
                if(coin[i] <= j && dp[j-coin[i]] != -1)
                {
                    // 기존에 계산했던 개수보다 작거나, 아직 계산이 안되었을 때
                    if(dp[j] > dp[j-coin[i]]+1 || dp[j] == -1)
                    {
                        dp[j] = dp[j -coin[i]]+1;
                    }
                }
            }
        }

        System.out.print(dp[size]);
    }
}
