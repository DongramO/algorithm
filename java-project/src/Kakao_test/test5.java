package Kakao_test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by idongsu on 2017. 9. 16..
 */
public class test5
{
    public static void main(String args[])
    {
        String str1 = "FRANCE";
        String str2 = "french";

        test5Sol ts = new test5Sol();
        ts.solution(str1,str2);

    }
}

class test5Sol
{
    public int solution(String str1, String str2) {
        String[] split_str1 = new String[str1.length() - 1];
        String[] split_str2 = new String[str2.length() - 1];
        int[] split_count1 = new int[str1.length()-1];
        int[] split_count2 = new int[str2.length()-1];
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 0; i < str1.length() - 3; ++i)
            split_str1[i] = str1.substring(i, i + 2);

        for (int i = 0; i < str1.length() - 3; ++i)
            split_str2[i] = str2.substring(i, i + 2);

        for(int i=0; i<split_str1.length; ++i)
        {
            for (int j = 0; j < split_str1.length; ++j) {
                if (split_str1[i].equals(split_str1[j]))
                    split_count1[i] += 1;
            }
        }

        for(int i=0; i<split_str2.length; ++i)
        {
            for (int j = 0; j < split_str2.length; ++j) {
                if (split_str2[i].equals(split_str2[j]))
                    split_count2[i] += 1;
            }
        }

        ArrayList<String> sum = new ArrayList<>(); // 합집합
        ArrayList<String> div = new ArrayList<>(); // 교집합

        for(int i=0; i< split_str1.length; ++i)
        {
            for(int j=0; j<split_str2.length; ++j)
            {

            }
        }

        System.out.println(Arrays.toString(split_str1));
        System.out.println(Arrays.toString(split_str2));
        System.out.println(Arrays.toString(split_count1));
        System.out.println(Arrays.toString(split_count2));
        int answer = 0;
        return answer;
    }
}
