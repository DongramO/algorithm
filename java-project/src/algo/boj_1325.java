package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 10/06/2019.
 */
public class boj_1325 {

    static ArrayList[] node;
    static List<Integer> list;
    static int[] result;
    static int cnt;
    static boolean[] visit;
    static int n;
    static int m;
    static int max;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        node = new ArrayList[n+1];
        result = new int[n+1];
        visit = new boolean[n+1];

        list = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();

        for(int i=0; i<m; ++i) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(node[b] == null) {
                t.add(a);
                node[b] = t;
            } else {
                ArrayList<Integer> k = node[b];
                k.add(a);
            }

        }

        for(int i=1; i<=n; ++i) {

            cnt = 0;
            visit = new boolean[n+1];
            dfs(i);
            result[i] = cnt;
            max = max(max, cnt);

        }

        for(int i=1; i<n+1; ++i) {
            if(result[i] == max) System.out.print(i +" ");
        }

    }

    static int max(int a, int b) {
        return ((a > b) ? a : b);
    }
    static void dfs(int start) {

        if(visit[start]) return;

        visit[start] = true;
        cnt++;

        ArrayList<Integer> t = node[start];
        if(t == null) return;

        for(int j=0; j<t.size(); ++j) {
            dfs(t.get(j));
        }

    }
}
