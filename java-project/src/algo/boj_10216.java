package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 N곳의 적군 진영이 있다, 진영마다 하나의 통신소를 가지고 있으며
 i번째 진영의 통신탑을 기준으로 R(i) 이내에 포함되는 영역을 통신영역 A(i)
 통신 영역이 겹치는 진영끼리는 서로 통신이 가능하다. -> recursive 필요
 서로 통신이 가능한 부대는 하나의 그룹으로 묶는다
 그룹의 개수를 알아 내어라
 */
public class boj_10216 {

    static boolean[] visit;
    static List<Dot> dot;
    static int cnt;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int flag = 0;
        dot = new ArrayList<>();

        while(flag < T) {

            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            dot = new ArrayList<>();

            for(int i=0; i<k; ++i) {

                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());

                dot.add(new Dot(x, y, a));
            }

            visit = new boolean[k];
            cnt = 0;

            for(int j=0; j<dot.size(); ++j) {

                // 이미 방문 했다는 것은 순회를 했다는 것,
                if(!visit[j]) {
                    dfs(dot.get(j), j);
                    cnt++;
                }
            }

            System.out.println(cnt);

            flag++;
        }

    }

    static void dfs(Dot d, int index) {

        if(visit[index]) return;

        visit[index] = true;

        for(int i=0; i < dot.size(); ++i) {

            if(i == index) continue;

            Dot nd = dot.get(i);

            int dx = (d.x - nd.x);
            int dy = (d.y - nd.y);
            int dis = dx * dx + dy * dy;
            int r = (d.a + nd.a);

            if(dis <= r*r) {
                dfs(nd, i);
            }

        }

    }


     static class Dot {

        int x,y,a;

        Dot(int x, int y, int a) {

            this.x = x;
            this.y = y;
            this.a = a;
        }
    }
}


