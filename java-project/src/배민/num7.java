package 배민;

import java.util.ArrayList;

/**
 * Created by idongsu on 17/03/2019.
 */
public class num7 {
    public static void main(String args[]) {
        char[] result = solve("browoanoommnaon");

        for(int i = 0; i < result.length; ++i) {
            System.out.print(result[i]);
        }
    }

    static char[] solve(String word) {
        boolean flag = true;

        char[] word_c = new char[word.length()+1];

        for(int i =0; i < word.length(); ++i) {
            word_c[i] = word.charAt(i);
        }



        while(flag) {
            char[] temp = new char[word_c.length+1];
            int index = 0;
            char dup = ' ';

            for(int i = 0 ;i < word_c.length-1; ++i) {
                if(word_c[i] == word_c[i+1]) {

                    dup = word_c[i];
                    flag = false;
                    continue;

                } else {

                    if(dup == word_c[i]) continue;
                    temp[index] = word_c[i];
                    index++;
                }
            }

            if(flag) {
                System.out.print("word : temp" + word_c.length + " : "+ temp.length);
                break;
            }
            System.out.println();

            word_c = new char[temp.length+1];

            for(int i =0; i < temp.length; ++i) {
                System.out.print(temp[i]);
                word_c[i] = temp[i];
            }
            word_c[temp.length] = ' ';
            System.out.println();
            flag = true;
        }

        return word_c;
    }
}
