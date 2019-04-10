package Kakao_test;

import java.util.*;

class test {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String str="";
        for(int i=0;i<n;i++)
        {
            String str1 = "";
            str = Integer.toBinaryString((byte)arr1[i] | (byte)arr2[i]);

            System.out.println(arr1[i] + " "+ arr2[i]);
            System.out.println(str);
            for(int j=0;j<str.length();j++) {

                if(str.substring(j, j+1).equals("1"))
                {
                    str1 += "#";
                }else {
                    str1 += " ";
                }
            }
            answer[i] = str1;
        }

        System.out.print(Arrays.toString(answer));
        return answer;
    }

    public static void main(String args[])
    {
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};
        solution(6, arr1, arr2);
    }
}