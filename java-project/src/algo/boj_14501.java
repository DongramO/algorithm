package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by idongsu on 01/06/2019.
 */
public class boj_14501 {
    static int[] time;
    static int[] price;
    static int size;
    static int[] dp;
    static int max;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String k = br.readLine().split(" ")[0];
        size = Integer.parseInt(k);

        dp = new int[23];
        time = new int[size+1];
        price = new int[size+1];

        String[] str;

        for(int i=0; i <size; i++) {
            str = br.readLine().split(" ");
            time[i] = Integer.parseInt(str[0]);
            price[i] = Integer.parseInt(str[1]);
        }

        for(int i = 0; i <=size; ++i) {
            dp[i + 1] =  Math.max(dp[i], dp[i+1]);
            dp[i+ time[i]] = Math.max(dp[i+time[i]], dp[i] + price[i]);
        }

        System.out.print(dp[size]);
    }

}

