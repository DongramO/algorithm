package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 2017. 8. 1..
 */
public class num_1475 {
    static public void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String insert = in.readLine();
        int[] num = new int[10];
        int  room,max;
        for(int i=0; i<insert.length(); i++)
        {
             room =  Integer.parseInt(insert.substring(i,i+1));
             for(int j=0; j<10; j++)  if(room == j) num[j]++;
        }

        max  = (int)Math.ceil(((double)num[6]+(double)num[9])/2);
        for(int j=0; j<10; j++)
        {
            if(j == 6 || j == 9) continue;
            max = Math.max(max, num[j]);
        }
        System.out.print(max);
    }
}
