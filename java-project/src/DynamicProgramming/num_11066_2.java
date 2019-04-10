package DynamicProgramming;

/**
 * Created by idongsu on 2017. 7. 17..
 */
public class num_11066_2
{
    public static void main(String args[])
    {

    }

    static int solve(int[][]dp, int[]c, int start, int end)
    {
       if(start == end)
       {
           return 0;
       }
       if(start +1 == end)
       {
           return c[start]+c[end];
       }


       for(int i=start; i<end ; i++)
       {
           int result = 0;

           for (int j = start; j < end; j++)
               result = c[j];

           int tmp = solve(dp, c, start, i) + solve(dp, c, i + 1, end) + result;
           dp[start][end] = Math.min(dp[start][end], tmp);
       }
       return dp[start][end];

    }
}
