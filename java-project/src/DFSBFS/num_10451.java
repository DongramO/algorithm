package DFSBFS;

import java.util.Scanner;

public class num_10451 {
    static public void main(String args[])
    {
        int[] ad;
        boolean[] visit;
        int k,v,e;
        int count;
        Scanner in = new Scanner(System.in);

        k = in.nextInt();
        for(int i=0; i<k; i++)
        {
            v = in.nextInt();
            visit = new boolean[v+1];
            ad = new int[v+1];

            for(int j=1; j<v+1; j++ )
            {
                ad[j] = in.nextInt();
                visit[j] = false;
            }

            count = 0;
            for(int m=1; m<v+1; m++)
            {
                if(visit[m] == false)
                {
                    dfs(m,visit,ad);
                    count++;
                }
            }
            System.out.println(count);
        }

    }

    static void dfs(int node, boolean[] visit,int[] ad)
    {
        if(visit[node]) return;

        visit[node] = true;
        dfs(ad[node],visit,ad);
    }
}
