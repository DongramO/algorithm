package algo;

import java.util.Stack;

/**
 * Created by idongsu on 07/03/2019.
 */
public class dfs_sample {

}


class Sample {

    // recursive dfs
    public static void dfs_recursive(int[][]a, boolean[] c, int v) {
        // a.length는 정점의 개수?
        int n = a.length -1;

        // c는 방문 배열
        c[v] = true;

        for(int i = 1; i <= n; i++) {
            dfs_recursive(a, c, i);
        }
    }

    // stack dfs
    public static void dfs_stack(int[][]a, boolean[] c, int v, boolean flag) {
        Stack<Integer> stack = new Stack<>();
        int n = a.length-1;

        stack.push(v);
        c[v] = true;

        while(!stack.isEmpty()) {
            int vv = stack.peek();
            flag = false;

            // 정점에 인접해있는 요소를 찾는다.
            for(int i = 1; i <= n; i++) {

                // 인접행렬과 방문 배열을 통해 1. 간선이 존재하는지, 2. 방문한적이 있는지 파악한다
                if(a[vv][i] == 1 && !c[i]) {
                    stack.push(i);
                    c[i] = true;
                    flag = true;
                    break;
                }
            }

            // 인접한 요소가 없는 경우 구냥 pop 해버리긔
            if(!flag) {
                stack.pop();
            }
        }
    }
}
