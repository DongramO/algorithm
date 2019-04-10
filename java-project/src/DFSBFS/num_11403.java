package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_11403 {
    static int[][] map;
    static int size;
    static int[][] result;
    static int[] visit;
    static public void main(String args[]) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        size = Integer.parseInt(in.readLine());
        map = new int[size][size];
        result = new int[size][size];

        for (int i = 0; i < size; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < size; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < size; ++i)
        {
            bfs(i);
            for(int k=0; k< size; ++k)
            {
                if(visit[k] == 1)
                {
                    result[i][k] = 1;
                    visit[k] = 0;
                }
            }
        }

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println("");
        }
    }


    public static void bfs(int i) {

       visit = new int[size];
        Queue<Integer> que = new <Integer>LinkedList();
        que.add(i);

        while (!que.isEmpty()) {
            int u = que.remove();

            for (int k = 0; k < size; ++k) {
                if (map[u][k] == 1 && visit[k] == 0) {
                    que.add(k);
                    visit[k] = 1;
                }
            }
        }
    }
}
