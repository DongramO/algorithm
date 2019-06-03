package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by idongsu on 02/06/2019.
 */
public class boj_2293 {

    public static void main(String args[]) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] k = in.readLine().split(" ");

        int kind = Integer.parseInt(k[0]);
        int size = Integer.parseInt(k[1]);

        int[] coin = new int[kind];
        int[] dp = new int[size+1]; //

        for(int i=0; i<kind; ++i) {
            coin[i] = Integer.parseInt(in.readLine());
        }

        Arrays.fill(dp,-1);
        dp[0] = 0;


    }
}
