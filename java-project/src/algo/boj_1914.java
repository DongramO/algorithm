package algo;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class boj_1914 {
    static int cnt = 0;
    static BufferedWriter bw;
    static String ans;
    static int size;
    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);

        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = sc.nextInt();

        BigInteger bi = new BigInteger("2");
        BigInteger c = bi.pow(size).subtract(BigInteger.ONE);
        System.out.println(c);

        if(size <= 20) {
            recursion( 1, 2, 3, size);
        }
    }

    public static void recursion(int start, int center, int end, int n) throws IOException {
        if(n == 1) {
            System.out.println(start+ " "+end);
        } else {
            recursion(start, end, center, n-1);
            System.out.println(start+ " "+end);
            recursion(center, start, end, n-1);
        }
    }
}