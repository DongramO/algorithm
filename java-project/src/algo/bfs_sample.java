package algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by idongsu on 08/03/2019.
 */

public class bfs_sample {

}

class bfs {
    public static void bfs(int[][] a, boolean[] c, int v) {
        Queue<Integer> q = new LinkedList<>();
        int n = a.length-1;

        // v는 아마 시작점 이겠지?
        q.add(v);
        c[v] = true;

        while(!q.isEmpty()) {
            v = q.poll();

            for(int i = 1; i <= n; i++) {
                if(a[v][i] == 1 && !c[i]) {
                    q.add(i);
                    c[i] = true;
                }
            }
        }
    }
}


