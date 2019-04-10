package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 2017. 10. 3..
 */
public class palindrom {

    static public void main(String args[]) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String word = in.readLine();
        String sequence = word;
        String reverse = "";
        int length = word.length();

        for(int i=0; i<word.length(); ++i)
        {
            reverse += String.valueOf(word.charAt(length-i-1));
        }
        String reverse_init = reverse;

        for(int i=0; i<length; ++i)
        {
            if(!sequence.equals(reverse))
            {
                sequence = sequence.substring(1);
                reverse = reverse.substring(0,length-i-1);
            }
            else
            {
                word += reverse_init.substring(length-i,length);
                break;
            }
        }
        System.out.print(word);
    }
}
