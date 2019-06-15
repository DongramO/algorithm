package algo;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by idongsu on 14/06/2019.
 */
public class boj_1094 {

    static int[] stick;
    static int sum;

    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        stick = new int[65];

        int c = 64;

        int cnt = 0;
        int a, b;

        sum = 0;
        if( x == 64) {
            System.out.println(1);
            return;
        }
        while(sum < x) {

            a = c/2; b = c/2;

            if( sum + a <= x) {
                c = a;
                sum += a;
                cnt++;
            } else {
                c = a;
            }
        }

        System.out.println("result " + cnt);
    }
}
