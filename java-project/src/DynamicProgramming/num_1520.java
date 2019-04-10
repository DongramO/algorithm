package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1520
{
    static public void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[]k = in.readLine().split(" ");

        int row = Integer.parseInt(k[0]);
        int col = Integer.parseInt(k[1]);

        int[][] arr = new int[row+1][col+1];
        int[][] dp = new int[row+1][col+1];
        int result = 0;

        for(int i=1;i<row+1;i++ )
        {
            st =  new StringTokenizer(in.readLine(), " ");
            for(int j=1; j<col+1; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j]  = -1;
            }
        }
        for(int i=row;i>0;i-- )
        {
            for(int j=col; j>0; j--)
            {
                result =0;
                solve(arr,dp, i,j,row,col,result);
            }
        }
        System.out.println(dp[1][1]);
    }

    static int solve(int[][] arr, int[][] dp,int m,int n, int row, int col, int result)
    {
        if(m == row && n == col)
        {
            return 1;
        }
        if(dp[m][n] != -1 ) return dp[m][n];

        else
        {
            dp[m][n] = 0;
            if (m - 1 > 0 && arr[m - 1][n] < arr[m][n])
            {
                dp[m][n] += solve(arr, dp, m - 1, n, row, col, result);;
            }
            if (m + 1 <= row && arr[m + 1][n] < arr[m][n])
            {
                dp[m][n] += solve(arr, dp, m + 1, n, row, col, result);
            }
            if (n - 1 > 0 && arr[m][n - 1] < arr[m][n])
            {
                dp[m][n] += solve(arr, dp, m, n - 1, row, col, result);
            }
            if (n + 1 <= col && arr[m][n + 1] < arr[m][n])
            {
                dp[m][n] += solve(arr, dp, m, n + 1, row, col, result);
            }
            return dp[m][n];
        }

    }
}

