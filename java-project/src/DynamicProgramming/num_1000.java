package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1000
{
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine(), " ");
        int[] tree = new int[3];
        for (int i = 0; i <2; i++)
        {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        System.out.print(tree[0]+tree[1]);
    }
}