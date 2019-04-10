package MST;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 2017. 10. 17..
 */
public class num_1647 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static public void main(String args[]) throws IOException
    {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parent = new int[n+1];

        // parent initialize
        for(int i=1; i<n+1; ++i) parent[i] = i;

        ArrayList<Node> Nlist = new ArrayList<Node>();
        for(int i=0; i<m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            Nlist.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(Nlist);

        for(int i=0; i<Nlist.size(); ++i)
        {
            System.out.println("start: " +Nlist.get(i).start+">>end:" +Nlist.get(i).end+">>wieght: "+Nlist.get(i).weight);
        }

        int result = 0;
        int cnt=0;
        int index=0;

        while(cnt < n-2)
        {
            Node N = Nlist.get(index++);
            int root1 = find(parent, N.start);
            int root2 = find(parent, N.end);

            // 사이클이 생기는 것을 방지
            if(root1 != root2)
            {
                union(parent, root1, root2);
                result += N.weight;
                cnt++;
            }
        }

        System.out.print(result);
    }

    static int find(int[] parent, int x)
    {
        if(x == parent[x]) return x;
        else return parent[x] = find(parent, parent[x]);
    }
    static void union(int[] parent, int x, int y)
    {
        x = find(parent, x);
        y = find(parent, y);
        parent[x] = y;
    }

}
class Node implements Comparable<Node> {
    int start;
    int end;
    int weight;

    Node(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}
