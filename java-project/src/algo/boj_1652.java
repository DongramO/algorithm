package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by idongsu on 15/04/2019.
 */
public class boj_1652 {

    static int size = 0;
    static int[][] arr;
    static int v_cnt = 0;
    static int h_cnt = 0;

    public static void main(String args[]) throws IOException {
        input();

        for(int i=0; i<size; ++i) {
            for(int j=0; j<size; ++j) {
                horizental(i,j);
                vertical(i,j);
            }
        }
        System.out.print(h_cnt + " " + v_cnt);
    }

    public static void vertical(int x, int y) {

        if( x < 0 ||  x >= size || y <0 || y>= size) return;
        if(x+1 >= size || arr[x+1][y] == 1) return;
        if(arr[x][y] == 1) return;
        if(x+2 == size) {
            v_cnt++;
            return;
        }
        if(x+2 <= size && arr[x+2][y] == 1) {
            v_cnt++;
            return;
        }
    }

    public static void horizental(int x, int y) {

        if( x < 0 ||  x >= size || y < 0 || y >= size) return;
        if(y+1 >= size || arr[x][y+1] == 1) return;
        if( arr[x][y] == 1) return;

        if(y+2 == size) {
            h_cnt++;
            return;
        }
        if(y+2 <= size && arr[x][y+2] == 1) {
            h_cnt++;
            return;
        }
    }

    public static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        arr = new int[size][size];

        String[] temp;

        for(int i=0; i<size; ++i) {
            temp = br.readLine().split("");
            for(int j=0; j<size; ++j) {

                //  0은 빈공간 1은 짐이 위치
                if(".".equals(temp[j])) arr[i][j] = 0;
                else arr[i][j] = 1;
            }
        }
    }

}
