package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 31/07/2019.
 */
public class boj_14888 {
    static int size;
    static int[] arr;
    static String[] str = new String[4];
    static int[] strCount = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int plus = 0;
    static int minus = 0;
    static int multi = 0;
    static int div = 0;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        arr = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int index = 0;

        while(st.hasMoreTokens()) {
            arr[index] = Integer.parseInt(st.nextToken());
            index++;
        }

        str = br.readLine().split(" ");

        plus = Integer.parseInt(str[0]);
        minus = Integer.parseInt(str[1]);
        multi = Integer.parseInt(str[2]);
        div = Integer.parseInt(str[3]);


        calculate(1, 0,0,0,0, arr[0]);

        System.out.println(max);

        System.out.println(min);
    }

    // 재귀가 끝나는 시점을 잡아줘야 한다.
    public static void calculate(int index, int pl, int mi, int mul, int di, int result) {

        if(index == size) {

            min = Math.min(min, result);
            max = Math.max(max, result);

            return;
        }

        if(pl < plus) calculate(index+1, pl+1, mi, mul, di, (result + arr[index]));

        if(mi < minus) calculate(index+1, pl, mi+1, mul, di, result - arr[index]);

        if(mul < multi) calculate(index+1, pl, mi, mul+1, di, result * arr[index]);

        if(di < div)  calculate(index+1, pl, mi, mul, di+1, result / arr[index]);

    }
}
