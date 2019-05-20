package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by idongsu on 10/04/2019.
 */
public class boj_14891 {

    static String[][] object;
    static int[] score = {0,1,2,4,8};
    static int total = 0;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        String[] temp;
        object = new String[5][8];

        for(int i=1; i<5; ++i) {
           temp = br.readLine().split("");
            for(int j=0; j<8; ++j) {
                object[i][j] = temp[j];
            }
        }

        int size = Integer.parseInt(br.readLine());

        int num = 0;
        int direction = 0;

        for(int i=0; i<size; ++i) {
            String[] tt = br.readLine().split(" ");

            num = Integer.parseInt(tt[0]);
            direction = Integer.parseInt(tt[1]);

            if(direction == 1) {
                reverse_clock(num);
            } else if(direction == -1) {
                clock(num);
            }

            for(int k=1; k<5; ++k) {
                for(int j=0; j<8; ++j) {
                    System.out.print(object[k][j]);
                }
                System.out.println();
            }
            System.out.println();
        }



        for(int i=1; i<5; ++i) {
            total += Integer.parseInt(object[i][0]) * score[i];
        }

        System.out.println(total);

    }

    public static void clock(int n) {
        String temp = "";

        // 주변 바퀴는 시계방향
        if(n != 1 ) {
            if(!object[n][6].equals(object[n-1][2])) {
                temp = object[n-1][7];
                for(int i=6; i>=0; --i) {
                    object[n-1][i+1] = object[n-1][i];
                }
                object[n-1][0] = temp;
            }
        }

        if(n != 4) {
            if(!object[n][2].equals(object[n+1][6])) {
                temp = object[n+1][7];
                for(int i=6; i>=0; --i) {
                    object[n+1][i+1] = object[n+1][i];
                }
                object[n+1][0] = temp;
            }
        }

        // 해당 바퀴는 반시계
        temp = object[n][0];
        for(int i=0; i<7; ++i) {
            object[n][i] = object[n][i+1];
        }
        object[n][7] = temp;
    }

    public static void reverse_clock(int n) {
        String temp = "";

        // 주변 톱니 반시계 방향
        if(n != 1) {
            if(!object[n][6].equals(object[n-1][2])) {
                temp = object[n-1][0];
                for(int i=0; i<7; ++i) {
                    object[n-1][i] = object[n-1][i+1];
                }
                object[n-1][7] = temp;
            }
        }

        if(n != 4) {
            if(!object[n][2].equals(object[n+1][6])) {
                temp = object[n+1][0];
                for(int i=0; i<7; ++i) {
                    object[n+1][i] = object[n+1][i+1];
                }
                object[n+1][7] = temp;
            }
        }

        // 해당 톱니 시계방
        temp = object[n][7];
        for(int i=6; i>=0; --i) {
            object[n][i+1] = object[n][i];
        }
        object[n][0] = temp;
    }
}
