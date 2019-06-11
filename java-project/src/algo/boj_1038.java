package algo;

import java.util.Scanner;


public class boj_1038 {

    static int cnt;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        long k = sc.nextInt();
        if( k == 0) {
            System.out.print(-1);
            return;
        }
        cnt = 0;
        search(k);
    }

    static void search(long k) {

        long index = 1;
        long max = 9876543210L;

        while(index <= max) {

            String[] n = String.valueOf(index).split("");

            boolean flag = true;

            for(int i=0; i<n.length-1; ++i) {

                if(Integer.parseInt(n[i]) <= Integer.parseInt(n[i+1])) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                cnt++;
                if(cnt == k) {
                    break;
                }
            }

            index++;
        }

        if(cnt == k ) System.out.print(index);
        else System.out.print(-1);


    }
}
