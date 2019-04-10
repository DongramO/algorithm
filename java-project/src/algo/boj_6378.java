package algo;

import java.util.Scanner;

/**
 * Created by idongsu on 05/04/2019.
 */
public class boj_6378 {
    static int split_sum;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String N = sc.nextLine();
            if(N.equals("0")) break;

            System.out.println(split(N));
        }
    }

    public static int split(String n) {
        String[] split_n = n.split("");
        split_sum = 0;

        for(int i=0; i<split_n.length; ++i) {
            split_sum += Integer.parseInt(split_n[i]);
        }

        if(split_sum > 10) split_sum = split(split_sum+"");

        return split_sum;
    }
}
