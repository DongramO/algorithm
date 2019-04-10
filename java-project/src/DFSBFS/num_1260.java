package DFSBFS;

import java.util.*;

/**
 * Created by idongsu on 2017. 8. 18..
 */
public class num_1260 {
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> ad;
    static int n;
    static int m;
    static int v;
    static public void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); // 정점의 개수
        m = in.nextInt(); // 간선의 개수
        v = in.nextInt(); // 시작할 정점의 번호

        visit = new boolean[n+1];
        ad = new ArrayList(n);

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

        for (int i=1; i<=n; i++) {
            Collections.sort(ad.get(i));
        }

        dfs(v);
        visit = new boolean[n+1];
        System.out.println();
        bfs(v);
    }

    static public void bfs(int x)
    {
        Queue<Integer> q = new <Integer>LinkedList();
        q.offer(x);

        while(!q.isEmpty())
        {
            int temp = q.poll();
            System.out.print(temp + " ");
            visit[temp] = true;
            // ArrayList에 있는 원소를 하나씩 꺼내준다.
            for(int j: ad.get(temp))
            {
                if(visit[j] == false)
                {
                    visit[j] = true;
                    q.offer(j);
                }
            }
        }
    }

    static public void dfs(int x)
    {
        // 방문한 노드를 true로 바꿔준다
        visit[x]  = true;
        System.out.print(x + " ");
        // 방문하지 않은 노드를 찾는다.
        for(int i: ad.get(x))
        {
            if(visit[i] == false)
            {
                dfs(i);
            }
        }
    }
}
