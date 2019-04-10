package Kakao_test;

/**
 * Created by idongsu on 2017. 8. 4..
 */
public class festival_1
{
    public static void main(String args[])
    {
        int[][] v = {{1, 1}, {2, 2}, {1, 2}};
        Solution sl = new Solution();
        sl.solution(v);
//        System.out.print(Arrays.toString());
    }
}
class Solution {
    public int[] solution(int[][] v)
    {
        int[][] num = new int[3][2];
        int[][] val = new int[3][2];
        int[] answer = new int[2];
        int flag =0;
        int l=0;
        for (int j = 0; j < 3; j++)
        {
            for (int k = 0; k < 2; k++)
            {
                for(int i=0; i< 3; i++)
                {
                    if(v[j][k] == v[i][k])
                        val[j][k]++;
                }
                if(val[j][k] % 2 != 0)
                {
                    for(int m= 0; m < answer.length; m++ )
                    {
                        if(answer[m] == v[j][k])
                        {
                            flag =1;
                            break;
                        }

                        else flag=0;
                    }
                    if(flag == 0)
                    {
                        if(k == 1)
                        {
                            answer[1] = v[j][k];
                            l++;
                        }
                        else
                        {
                            answer[0] = v[j][k];
                            l++;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
