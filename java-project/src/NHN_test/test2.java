package NHN_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 2017. 9. 21..
 */
public class test2 {
    static public void main(String args[]) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(in.readLine());

        int[][] arr = new int[n][n];
        int[][] arr2 = new int[n][n];

        for(int i=0; i<n; ++i)
        {
            st= new StringTokenizer(in.readLine());
            for(int j=0; j<n; ++j)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
                arr2[j][i] = arr[i][j];
            }
        }

        for(int i=0; i<n; ++i)
        {
            for(int j=0; j<n; ++j) {
                System.out.print(arr2[i][j]);
                if(j != -1)
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
