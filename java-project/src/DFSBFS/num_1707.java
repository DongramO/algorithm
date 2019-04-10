package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class num_1707
{
    static int k; // 테스트케이스 개수
    static int v; // 정점의 개수
    static int e; // 간선의 개수
//    static boolean[] visit; // 방문여부 별로 필요 없음
    static int[] color; // 노드의 색을 판별하는 배열
    static ArrayList<ArrayList<Integer>> ad;
    static boolean result;

    static public void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++)
        {
            // input
            StringTokenizer st = new StringTokenizer(br.readLine());

            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            color = new int[v+1];
            result = true;
            ad = new ArrayList<ArrayList<Integer>>();

            // 배열 및 리스트 초기화
            Arrays.fill(color,0);
            for(int j=1; j<=v+1; j++)
            {
                ad.add(new ArrayList<Integer>());
            }

            for(int j=0; j<e; j++)
            {
                st = new StringTokenizer(br.readLine());
                int t1 = Integer.parseInt(st.nextToken());
                int t2 = Integer.parseInt(st.nextToken());

                ad.get(t1).add(t2);
                ad.get(t2).add(t1);
            }

            // 연결요소를 가질 경우도 있기 때문에 모든 노드에 대해서 확인해 주어야 한다.
            // 색을 가지고 있는 경우 방문한 적이 있기 때문에 0이 아닌경우 확인 해줄 필요가 없다.
            // 이미 한번의 결과의 값이 false 인 경우 답은 NO
            for(int m=1; m<v+1; m++)
            {
                if(!result) break;

                if(color[m] == 0)
                {
                    dfs(m,1);
                }
            }
            System.out.println(result ? "YES" : "NO");
        }
    }

    static void dfs(int x,int c) {

        color[x] = c;
        for (int i : ad.get(x)) {

            if (color[i] == c ) {

                result = false;
                return;
            }

            if (color[i] == 0) {
                dfs(i, -c);
            }
        }
    }
}

