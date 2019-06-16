package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 15/06/2019.
 */

public class boj_1010 {

    static int t;
    static int n,m;
    static int cnt = 0;
    static int[][] cache;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        cache = new int[31][31];

        int index = 0;

        while(index < t) {

            cnt = 0;

            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            System.out.println(recursion(m , n));

            index++;
        }



    }

    static int recursion(int n, int r) {

        if(r == 0 || n == r) return 1;

        if(cache[n][r] != 0) return cache[n][r];

        return cache[n][r] = recursion(n-1, r)  + recursion(n-1, r-1);
    }
}
