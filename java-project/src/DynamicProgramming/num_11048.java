package DynamicProgramming;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 2017. 9. 11..
 */
public class num_11048
{
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[]k = in.readLine().split(" ");
        int n = Integer.parseInt(k[0]);
        int m = Integer.parseInt(k[1]);

        int[][] array = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<n+1 ; ++i)
        {
            st =  new StringTokenizer(in.readLine(), " ");
            for(int j=0; j<m; ++j)
            {
                array[i][j+1] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = array[1][1];
        for(int i=1; i<n+1 ; ++i)
        {
            for(int j=1; j<m+1; ++j)
            {
                dp[i][j] = array[i][j];
                int temp1=0,temp2=0,temp3=0;
                if(i-1 > 0)
                {
                    temp1 = dp[i-1][j];
                }
                if(j-1 > 0)
                {
                    temp2 = dp[i][j-1];
                }
                if(j-1 >0 && i-1 > 0)
                {
                    temp3 = dp[i - 1][j - 1];
                }
                dp[i][j] += Math.max(temp1 , Math.max(temp2, temp3));
            }
        }

        for(int i=1; i<n+1 ; ++i)
        {
            for(int j=1; j<m+1; ++j)
            {
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println("");
        }
        System.out.print(dp[n][m]);


    }
}
