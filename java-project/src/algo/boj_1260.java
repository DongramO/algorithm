package algo;
import java.io.IOException;
import java.util.*;

/**
 * Created by idongsu on 11/03/2019.
 */
public class boj_1260 {

    public static void main (String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int node = sc.nextInt();
        int line = sc.nextInt();
        int start = sc.nextInt();

        int[][] ad = new int[node+1][node+1];
        int[] visit = new int[node+1];

        for(int i = 0; i < line; ++i) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            ad[a][b] = 1;
            ad[b][a] = 1;
        }

        Graph solve = new Graph();
        ArrayList<Integer> dfs = solve.dfs(ad, visit, start);

        for(int i =0; i < dfs.size(); ++i) {
            System.out.print(dfs.get(i) + " ");
        }
        System.out.println("");
        visit = new int[node+1];

        ArrayList<Integer> bfs = solve.bfs(ad, visit, start);
        for(int i =0; i < bfs.size(); ++i) {
            System.out.print(bfs.get(i) + " ");
        }

    }
}

class Graph {
    public static ArrayList<Integer> bfs(int[][] ad, int[] visit, int start) {
        Queue<Integer> q = new LinkedList<>();

        ArrayList<Integer> result = new ArrayList<>();

        q.add(start);
        visit[start] = 1;
        int n = ad.length -1;

        while(!q.isEmpty()) {
            start = q.poll();
            result.add(start);

            for(int i = 1; i <= n; ++i) {
                if(ad[start][i] != 0 && visit[i] == 0) {
                    q.add(i);
                    visit[i] = 1;
                }
            }
        }
        return result;
    }

    public static ArrayList<Integer> dfs(int[][] ad, int[] visit, int start) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        int n = ad.length -1;
        visit[start] =1;
        stack.push(start);
        result.add(start);

        while(!stack.isEmpty()) {
            boolean flag = false;
            int v = stack.peek();

            for(int i=1; i<=n; ++i) {
                if(ad[v][i] != 0 && visit[i] == 0) {
                    stack.push(i);
                    result.add(i);
                    visit[i] = 1;
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                stack.pop();
            }
        }
        return result;
    }
}
