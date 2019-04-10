package Kakao_test;

/**
 * Created by idongsu on 2017. 9. 15..
 */
public class demoTest1
{
    public static void main(String args[])
    {

    }
}
class Test_Solution
{
    public int solution(int n)
    {
        int answer = 0;
        String[] N = String.valueOf(n).split("");

        for(int i=0; i<N.length; ++i)
        {
            answer += Integer.parseInt(N[i]);
        }


        return answer;
    }
}
