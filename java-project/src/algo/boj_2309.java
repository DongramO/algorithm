package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 10/06/2019.
 */
public class boj_2309 {
    // 부분집합을 브루트 포스로 찾아내기

    static int[] t;
    static int sum;

    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);
        t = new int[9];
        for(int i=0; i<9; ++i) {
            t[i] = sc.nextInt();
        }

        int[] result =  new int[7];
        boolean[] visit = new boolean[9];

        recursive(0, 0, 0, result);
    }

    static void recursive(int start, int depth, int index, int[] result) {

        if(depth == 7) {
            if(check(result)) {
                Arrays.sort(result);
                for(int j=0; j<7; ++j) {
                    System.out.println(result[j]);
                }
            }
            return;
        }

        if(index == 9) return;

        result[depth] = t[start];

        // 해당 원소를 포함한 경우
        recursive(start+1, depth+1, index+1, result);

        // 해당 원소를 포함하지 않은 경우
        recursive(start+1, depth, index+1, result);

    }

    static boolean check(int[] result) {
        int sum = 0;

        for(int i=0; i<result.length; ++i) {
            sum += result[i];
        }

        if(sum == 100) return true;

        return false;
    }
}
