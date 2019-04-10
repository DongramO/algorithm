package DFSBFS;
import java.util.Scanner;

/**
 * Created by idongsu on 2017. 8. 18..
 */
import java.util.*;
class Edge {
    int from, to;
    Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
}
public class num_13023{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] a = new boolean[n][n];

        ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[n];
        ArrayList<Edge> edges = new ArrayList<Edge>();

        for (int i=0; i<n; i++) {
            g[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            // 간선을 모두 담는다. 넌 왜있냐..?
            edges.add(new Edge(from, to));
            edges.add(new Edge(to, from));
            // 연결 여부를 판별하는 배열
            a[from][to] = a[to][from] = true;
            // 간선을 모두 담는다
            //어디서 어디로 가는지 저장
            g[from].add(to);
            g[to].add(from);
        }
        System.out.println(" m의 크기" + m);
        m *= 2; //양방이기 때문에 *2를 해준다 m은 친구 관계수
        System.out.println(" m의 크기" + m);
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
