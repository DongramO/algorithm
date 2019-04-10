package DFSBFS;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by idongsu on 2017. 8. 18..
 */
public class num_13023_exam
{
    static public void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] a = new boolean[n][n];
        ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[n];
        ArrayList<ArrayList<Integer>> k = new ArrayList<>();
        ArrayList<Edge2> edges = new ArrayList<>();

        for(int i=0; i<m; i++)
        {
             int from  = sc.nextInt();
             int to = sc.nextInt();

             edges.add(new Edge2(from, to));

             a[from][to] = a[to][from] = true;

             g[from].add(to);
             g[to].add(from);
        }

        m *= 2;
        for  (int i=0; i<m; i++)
        {
            for (int j=0; j<m; j++)
            {

                int A = edges.get(i).from;
                int B = edges.get(i).to;
                int C = edges.get(j).from;
                int D = edges.get(j).to;

                if (A == B || A == C || A == D || B == C || B == D || C == D) {
                    continue;
                }
                if (!a[B][C]) continue;
                for (int E : g[D]) {
                    if (A == E || B == E || C == E || D == E) {
                        continue;
                    }
                    System.out.println(1);
                    System.exit(0);
                }
            }
        }
        System.out.println(0);
    }
}

class Edge2
{
    int from,to;
    Edge2(int from, int to)
    {
        this.from =from;
        this.to = to;
    }
}
