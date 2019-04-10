package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by idongsu on 2017. 9. 28..
 */
public class num_2228 {
    static public void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        for(int i=1; i<n+1; i++)
        {
            arr[i] = in.nextInt();
            sum[i] = sum[i-1]+arr[i];
        }

    }

//    static int Solve2228(int n, int m)
//    {
//        int temp = 0;
//
//        if(m == 0) return 0;
//        if(n <0)
//        return 0;
//    }
}
