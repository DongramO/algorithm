package DFSBFS;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by idongsu on 2017. 8. 19..
 */
public class num_11724 {

    static int m,n;
    static ArrayList<ArrayList<Integer>> ad;
    static boolean[] visit;
    static int count;
    static public void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); // 정점의 개수
        m = in.nextInt(); // 간선의 개수

        ad = new ArrayList(n+1);
        visit = new boolean[n+1];

        for(int i=1; i<=n+1; i++)
        {
            ad.add(new ArrayList());
        }

        for(int i=1; i<m+1; i++)
        {
            int t1 = in.nextInt();
            int t2 = in.nextInt();

            ad.get(t1).add(t2);
            ad.get(t2).add(t1);
        }

        for(int i=1; i<n+1; i++)
        {
            if(visit[i] == false)
            {
                count++;
                dfs(i);
            }
        }
        System.out.print(count);
    }
    // 루프를 이루는지 안 이루는지 알아볼 방법은? -> 처리하면 문제 해결
    static public void dfs(int x)
    {
        if(visit[x]) return;

        visit[x]  = true;

        for(int i: ad.get(x))
        {
            if(visit[i] == false)
            {
                dfs(i);
            }
        }
    }
}
