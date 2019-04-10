package Kakao_test;

/**
 * Created by idongsu on 2017. 9. 15..
 */
public class demoTest6 {
    public static void main(String args[])
    {
        Solution6 st = new Solution6();
        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
        st.solution(sticker);
    }
}

class Solution6 {
    public int solution(int sticker[]) {
        int answer = 0;
        int[] arr = new int[sticker.length+2];
        int odd = 0;
        int even = 0;
        int result;

        for(int i=1; i<sticker.length; ++i)
        {
            arr[i] = sticker[i-1];
        }
        arr[0] = sticker[sticker.length-1];
        arr[sticker.length+1] = sticker[0];

        for(int i=1; i<sticker.length; ++i)
        {
          if(i%2 ==0) even += sticker[i];
          else odd += sticker[i];
        }

        answer = Math.max(odd,even);
        System.out.print(answer);
        return answer;
    }
}