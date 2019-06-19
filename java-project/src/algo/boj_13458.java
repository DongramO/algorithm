package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 16/06/2019.
 */
public class boj_13458 {

    static int area;
    static long[] amount;
    static long a,b;
    static long cnta;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        area = Integer.parseInt(st.nextToken());

        amount = new long[area];

        st = new StringTokenizer(br.readLine());

        int index = 0;

        while(st.hasMoreTokens()) {
            amount[index] = Integer.parseInt(st.nextToken());
            index++;
        }

        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        cnta = 0;


        solveA();
        solveB();

        System.out.print(cnta);
    }

    static void solveA() {

        for(int i=0; i<amount.length; ++i) {

            amount[i] = amount[i] - a;
            if(amount[i] < 0) amount[i] = 0;
            cnta++;
        }

    }

    static void solveB() {

        for(int i=0; i<amount.length; ++i) {
            if(amount[i] != 0) {
                System.out.println(amount[i]);
                cnta += Math.ceil(amount[i]/b);
            }
        }
    }
}
