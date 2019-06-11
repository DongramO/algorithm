package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 10/06/2019.
 */
public class boj_7568 {

    static int n;
    static int[] t;
    static int[] k;
    static int[] result;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        t = new int[n];
        k = new int[n];
        result = new int[n];

        for(int i=0; i<n; ++i){

            st = new StringTokenizer(br.readLine());

            k[i] = Integer.parseInt(st.nextToken());
            t[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=0; i<n; i++) {

            int x = k[i];
            int y = t[i];
            int rank = 1;

            for(int j=0; j<n; ++j) {

                int nx = k[j];
                int ny = t[j];

                rank = compare(x,y,nx,ny,rank);
            }

            result[i] = rank;
        }

        for(int i=0; i<n; ++i) {
            System.out.print(result[i]+" ");
        }
    }

    static int compare(int x1, int y1, int x2, int y2, int rank) {
        if( x1 < x2 && y1 < y2) {
            return ++rank;
        }
        return rank;
    }
}
