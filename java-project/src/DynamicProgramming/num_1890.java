package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1890 {
    public static void main(String args[]) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(in.readLine());

        int[][] map = new int[n+1][n+1];
        //dp 원소로는 0,0으로 갈 수 있는 방법의 수를 넣는다
        long[][] dp = new long[n+1][n+1];

        for(int i=1; i<n+1; i++)
        {
            st = new StringTokenizer(in.readLine()," ");
            for(int j=1; j<n+1; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 배열범위 확인
        // 2. 목적지 인지 확인
        for(int i=n; i>0; --i)
        {
            for(int j=n; j>0; --j)
            {
                int temp = map[i][j];


                if(temp == 0) continue;
                if(i+temp < n+1)
                {
                    if((i+temp)==n && j ==n )
                        dp[i][j] = 1;
                    else
                       dp[i][j] += dp[i+temp][j];
                }
                if(j+temp < n+1)
                {
                    if(i ==n && (j+temp)==n )
                        dp[i][j] = 1;
                    else
                        dp[i][j] += dp[i][j+temp];
                }
            }
        }
        System.out.println(dp[1][1]);
        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<n+1; j++)
            {
                System.out.print(dp[i][j]);
            }
            System.out.println("");
        }
    }
}
