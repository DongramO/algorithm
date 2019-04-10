package MST;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class num_2887 {
    static public void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Planet[] Plist = new Planet[n];
        ArrayList<Edge> Tlist = new ArrayList<Edge>();
        int[] parent = new int[n];
        for(int i=0; i<n; ++i)
        {
            parent[i] = i;
            st = new StringTokenizer(br.readLine());
            Plist[i] = new Planet(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),i);
        }

        Arrays.sort(Plist, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.x - o2.x;
            }
        });

        for(int i=0; i<n-1; ++i)
        Tlist.add(new Edge(Plist[i].num, Plist[i+1].num, Math.abs(Plist[i].x-Plist[i+1].x)));

        Arrays.sort(Plist, new Comparator<Planet>(){
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.y - o2.y;
            }
        });

        for(int i=0; i<n-1; ++i)
            Tlist.add(new Edge(Plist[i].num, Plist[i+1].num, Math.abs(Plist[i].y - Plist[i+1].y)));

        Arrays.sort(Plist, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.z - o2.z;
            }
        });

        for(int i=0; i<n-1; ++i)
            Tlist.add(new Edge(Plist[i].num, Plist[i+1].num, Math.abs(Plist[i].z - Plist[i+1].z)));

        Collections.sort(Tlist);

        int result = 0;
        int cnt=0;
        int index=0;

        while(cnt < n-1)
        {
            Edge E = Tlist.get(index++);
            int root1 = find(parent, E.start);
            int root2 = find(parent, E.end);

            // 사이클이 생기는 것을 방지
            if(root1 != root2)
            {
                union(parent, root1, root2);
                result += E.weight;
                cnt++;
            }
        }

        System.out.print(result);

    }

    static int find(int[] parent, int x)
    {
        if(x == parent[x])
            return parent[x];
        else
            return parent[x] = find(parent,parent[x]);
    }
    static void union(int[] parent, int x, int y)
    {
        x = find(parent, x);
        y = find(parent, y);
        parent[x] = y;
    }

}

class Planet{
    int x;
    int y;
    int z;
    int num;

    Planet(int x, int y, int z, int num)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.num = num;
    }
}
class Edge implements Comparable<Edge>{
    int start;
    int end;
    int weight;

    Edge(int start, int end,int weight)
    {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return weight - o.weight; //오름차순 정렬
    }
}
