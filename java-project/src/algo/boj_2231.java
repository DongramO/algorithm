package algo;

import java.util.Scanner;

public class boj_2231 {
    static int split_sum = 0;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.print(solve(N));
    }
    public static int solve(int N) {

        int index = 0;
        int value = 0;

        while(index < N) {
            int solve = split(index) + index;
            if(solve == N) {
                if(value == 0) value = index;
                value = Math.min(value, solve);
            }
            index++;
        }

        return value;
    }

    public static int split(int index) {
        String temp = index+"";
        String[] split_n = temp.split("");
        split_sum = 0;

        for(int i=0; i<split_n.length; ++i) {
            split_sum += Integer.parseInt(split_n[i]);
        }
        return split_sum;
    }
}
