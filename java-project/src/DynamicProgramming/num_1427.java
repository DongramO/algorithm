package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by idongsu on 2017. 8. 1..
 */
public class num_1427
{
    static public void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String insert = in.readLine();
        int[] num = new int[insert.length()];
        int room;
        for (int i = 0; i < insert.length(); i++)
        {
            room = Integer.parseInt(insert.substring(i, i + 1));
            num[i] = room;
        }
        Arrays.sort(num);
       for(int k = num.length-1; k>=0; k--)
           System.out.print(num