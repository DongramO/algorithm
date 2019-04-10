package Kakao_test;

import java.util.Arrays;

/**
 * Created by idongsu on 2017. 8. 5..
 */
public class fetive_1
{
    public static void main(String args[])
    {
        Solution1 sl = new Solution1();
        int m=3;
        int n=6;
        int[][] picture = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
        System.out.print(sl.solution(m,n,picture));
    }
}
class Solution1
{
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap)
    {
        int answer = 0;
        int[][] dp = new int[m+1][n+1];
        int[][][] dp2= new int[m+1][n+1][2];
        int result = 0;

        for(int i=0;i<m;i++)
        {
            for(int j=0; j<n; j++)
            {
                dp[i][j] = -1;
                dp2[i][j][0] =0;
                dp2[i][j][1] =0;
            }
        }
        solve(cityMap,dp,dp2,0,0,m,n,0);
        answer = dp[0][0];
        for(int i=0; i<m; i++)
            System.out.println(Arrays.toString(dp[i]));

        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(dp2[i][j][0] + "#" + dp2[i][j][1]+"\t");
            System.out.println(" ");
        }
        return answer;
    }

    public int solve(int[][] arr, int[][] dp,int[][][]dp2,int m,int n, int row, int col, int direct)
    {

        if(m == row-1 && n == col-1)
        {
            return 1;
        }
        if(dp[m][n] != -1)
        {
            if(dp2[m][n][0] != -1 && direct == 1)
            {
                return dp2[m][n][0];
            }
            if(dp2[m][n][0] != -1 && direct == 3)
            {
                return dp2[m][n][1];
            }
                return dp[m][n];

        }
        if(arr[m][n] == 1) return 0;
        else
        {

            dp[m][n] = 0;
            if(m + 1 < row && arr[m][n] == 2 && direct == 1)
            {
                dp[m][n] += solve(arr, dp,dp2, m + 1, n, row, col, 1);
                dp2[m][n][0] += dp[m][n];
            }
            else if(n + 1 < col && arr[m][n] == 2 && direct == 3)
            {
                dp[m][n] += solve(arr, dp, dp2, m, n + 1, row, col, 3);
                dp2[m][n][1] += dp[m][n];
            }
            else
            {
                if (m + 1 < row && arr[m][n] == 0)
                {
                    dp[m][n] += solve(arr, dp, dp2, m + 1, n, row, col, 1);
                    dp2[m][n][0] += dp[m][n];
                }
                if (n + 1 < col && arr[m][n] == 0)
                {
                    dp[m][n] += solve(arr, dp, dp2, m, n + 1, row, col, 3);
                    dp2[m][n][1] += dp[m][n];
                }
            }

            return dp[m][n];
        }

    }
}