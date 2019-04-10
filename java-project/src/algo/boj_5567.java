package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by idongsu on 04/04/2019.
 */
public class boj_5567 {
    static int [][] arr;
    static int [] visit;
    static int cnt = 0;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int friend = sc.nextInt();
        int size = sc.nextInt();

        arr = new int[friend+1][friend+1];
        visit = new int[friend+1];
        ArrayList<Integer> list = new ArrayList<>();

        // 인접 리스트 생성
        for(int i=0; i<size; ++i) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            if( a == 1) {
                cnt++;
                visit[b] = 1;
                list.add(b);
            }

            arr[a][b] = 1;
            arr[b][a] = 1;
        }


        for(int i: list) {
            for(int j=2; j <= friend; ++j) {
                if(arr[i][j] == 1 && visit[j] == 0) {
                    cnt++;
                    visit[j] = 1;
                }
            }
        }
        System.out.println(cnt);
    }


    public static void bfs(int[][] arr, int[] visit, int start) {
        Queue<Integer> q = new LinkedList<>();

        visit[start] = 1;
        q.add(start);
        int depth = 0;
        int check = 0;
        // 큐를 생성하고 탐색하는 과정
        // 조건 : 상근이의 친구, 친구의 친구까지만 결혼식에 초대한다.
        // depth를 구분 해야하는데....

        while(!q.isEmpty()) {
            start = q.poll();

            System.out.println("start :"+ start+ " depth : "+depth);

            for(int i=1; i<= arr.length-1; ++i) {
                if(arr[start][i] == 1 && visit[i] == 0) {
                    q.add(i);
                    visit[i] = 1;
                    cnt++;
                }
            }
            System.out.println();
        }
    }

    public static void dfs(int[][] arr, int[] visit, int start, int depth) {
        if(start >= arr.length) return;
        if(visit[start] == 1 || depth > 2) return;

        visit[start] = 1;
        cnt++;
        dfs(arr, visit, start+1, depth+1);
    }
}
