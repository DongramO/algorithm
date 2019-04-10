package Kakao_test;

public class demoTest2
{
    public static void main(String args[])
    {
        int[] arr= {4,1,3,2};
        Test_Solution2 ts2 = new Test_Solution2();
        ts2.solution(arr);
    }
}
class Test_Solution2
{
    public boolean solution(int[] arr)
    {
        int[] answer_arr = new int[arr.length+1];
        System.out.println(arr.length);
        for(int i=0; i<arr.length; ++i)
        {
            int temp = arr[i];
            if(temp>arr.length || answer_arr[temp] != 0) {
                System.out.print("false");
                return false;
            }
            answer_arr[temp] = 1;

        }

        return true;
    }
}
