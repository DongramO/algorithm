package Kakao_test;

/**
 * Created by idongsu on 2017. 9. 15..
 */
public class demoTest5 {
    public static void main(String args[])
    {
        Solution5  st = new Solution5();
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        st.solution(land);
    }
}

class Solution5 {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];


        // 마지막줄 dp에 추가
        for(int i=0; i<4; ++i)
        {
            dp[land.length-1][i] = land[land.length-1][i];
        }

        for(int i=land.length-2; i>=0; --i) {
            for(int j=0; j<4; ++j) {
                int temp =0;

                for(int k=0; k<4; ++k) {
                    if(j != k)
                        temp = Math.max(temp, dp[i + 1][k]);
                }

                dp[i][j] = land[i][j] + temp;
            }
        }

        for(int i=0; i<4; ++i)
        {
            answer = Math.max(answer,dp[0][i]);
        }

        return answer;
    }
}