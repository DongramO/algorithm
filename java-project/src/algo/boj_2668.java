package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
Cycle 패턴과 result 값을 잘 관리하는게 중요하다.
 */

public class boj_2668 {

    static int[][] map;
    static int max = 0;
    static List<Integer> result;
    static boolean[] visit;
    private static int n;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new int[2][n+1];
        visit = new boolean[n+1];
        result = new ArrayList<>();

        for(int i=0; i<n; ++i) {
            map[0][i] = i+1;
        }

        for(int i=0; i<n; ++i) {
            st = new StringTokenizer(br.readLine());
            map[1][i+1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; ++i) {
            visit = new boolean[n+1];
            dfs(i, i);
        }

        Collections.sort(result);
        System.out.println(result.size());

        for(int i=0; i< result.size(); ++i) {
            System.out.println(result.get(i));
        }
    }

    static boolean dfs(int v, int start) {

        if(visit[v]) {

            if(v == start) {
                result.add(v);
                return true;
            }

            return false;

        } else {

            visit[v] = true;

            if(dfs(map[1][v], start)) {
                return true;
            }

            return false;

        }
    }
}
