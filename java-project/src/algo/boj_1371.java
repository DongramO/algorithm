package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by idongsu on 05/04/2019.
 */
public class boj_1371 {
    static int[] result;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        result = new int[26];

        while(true) {
            String line = br.readLine();

            if(line == null)
                break;

            split(line);
        }

        int max = 0;

        for(int j=0; j<result.length; ++j) {
            max = Math.max(result[j], max);
        }

        for(int j=0; j<result.length; ++j) {
            if(result[j] == max) {
                System.out.print((char)(j+'a'));
            }
        }

    }

    public static void split(String n) {
        for(int i=0; i < n.length(); ++i) {

            char k = n.charAt(i);
            if (k == '\n' || k == ' ')
                continue;
            result[k-'a']++;
        }
    }
}
