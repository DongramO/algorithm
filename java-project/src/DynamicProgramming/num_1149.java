package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_1149
{
    static public void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        int[] R,G,B;


        R = new int[T+1];
        G = new int[T+1];
        B = new int[T+1];

        for(int i=1;i<T+1;i++)
        {
            String[] RGB = in.readLine().split(" ");
            int r = Integer.parseInt(RGB[0]);
            int g = Integer.parseInt(RGB[1]);
            int b = Integer.parseInt(RGB[2]);

            R[i] = r + Math.min(G[i-1],B[i-1]);
            G[i] = g + Math.min(R[i-1],B[i-1]);
            B[i] = b + Math.min(R[i-1],G[i-1]);

        }
        int result = Math.min(R[T],Math.min(G[T],B[T]));
        System.out.print(result);
    }
}
