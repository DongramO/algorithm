package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by idongsu on 2017. 7. 30..
 */
public class num_9461 {
    static public void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        long dp[] = new long[101];
        dp[1] = 1; dp[2] = 1; dp[3]= 1; dp[4] = 2;
        int k=0;

        for(int i =1; i< T+1; i++)
        {
            k = Integer.parseInt(in.readLine());
            if(k>4)
            {
                for(int j =4; j<=k; j++)
                    dp[j]= dp[j-3]+dp[j-2];
            }
            System.out.println(dp[k]);
        }
    }
}
