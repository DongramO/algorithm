package algo;

import java.util.Scanner;

/**
 * Created by idongsu on 03/04/2019.
 */
public class boj_1182 {
    static int[] arr;
    static int cnt;
    static int size;
    static int sum;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        sum = sc.nextInt();

        arr = new int[size];

        for(int i=0; i<size; ++i) {
            arr[i] = sc.nextInt();
        }

//        System.out.println("구해야하는 값 : "+ sum);

        for(int i=0; i<size; ++i) {
            dfs(arr, i, 0);
        }

        System.out.print(cnt);
    }

    public static void dfs(int[] arr, int i, int 누적) {
        if(i >= size) return;

        누적 += arr[i];
        if(sum == 누적) {
            cnt++;
        }

        for(int t = i; t< size; ++t) {
            dfs(arr, t+1, 누적);
        }
    }
}
