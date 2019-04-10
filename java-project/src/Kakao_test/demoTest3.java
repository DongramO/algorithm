package Kakao_test;

import java.util.Arrays;

public class demoTest3
{
    public static void main(String args[])
    {
        int[][] v = {{1,4},{3,4},{3,10}};
        Test_Solution3 ts = new Test_Solution3();
        ts.solution(v);
    }
}
class Test_Solution3
{
    public int[] solution(int[][] v) {
        int[] answer = new int[2];
        int[] x = new int[3];
        int[] y = new int[3];

        for(int i=0; i<3; ++i)
        {
            x[i] = v[i][0];
            y[i] = v[i][1];
        }

        for(int i=0; i<3; ++i)
        {
            int m = x[i];
            int mcount = 0;
            int n = y[i];
            int ncount = 0;
            for(int j=0; j<3; j++)
            {
                if(m == x[j]) mcount++;
                if(n == y[j]) ncount++;
            }
            if(mcount == 1) answer[0] = m;
            if(ncount == 1) answer[1] = n;
        }

        System.out.print(Arrays.toString(answer));
        return answer;
    }
}
