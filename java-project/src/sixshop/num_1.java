package sixshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by idongsu on 06/04/2019.
 */
public class num_1 {

    public static void main(String args[]) {
        List<String> strings = new ArrayList<>();
    }

    public static String isPangram(List<String> strings) {
        // Write your code here
        String result = "";
        int[] word = new int[27];

        for(int i =0; i<strings.size(); ++i) {

            String sample = strings.get(i);

            for (int j = 0; j < sample.length(); ++j) {
                char t = sample.charAt(i);
                if(t == ' ') continue;
                else {
                    word[j] = (int) (sample.charAt(j) - 'a');
                }
            }


            for(int j=0; j<word.length; ++j) {
                if(word[j] == 0) result +=0;
            }
            result += 1;
        }

        return result;
    }

}
