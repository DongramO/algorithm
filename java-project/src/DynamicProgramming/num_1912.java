package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 2017. 7. 24..
 */
public class num_1912
{
    static public void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(in.readLine());

        long[] tree = new long[T + 1];
        long[] dp = new long[T + 1];
        st = new StringTokenizer(in.readLine(), " ");
        for (int i = 1; i < T + 1; i++)
        {
            tree[i] = Long.parseLong(st.nextToken());
        }
        long temp =0;
        long result =-1000;

        for(int i = 1 ;i < T+1;i++)
        {
            dp[i] = Math.max(dp[i-1] + tree[i], tree[i]);
            result = Math.max(result, dp[i]);
        }

//        for(int i=1; i< T+1; i++)
//        {
//            temp = 0;
//            dp = new long[T+1];
//            for(int j=i; j<T+1; j++)
//            {
//                temp = dp[j-1] + tree[j];
//                result = Math.max(result,temp);
//                dp[j] = temp;
//            }
//        }
        System.out.print(result);
    }


}

