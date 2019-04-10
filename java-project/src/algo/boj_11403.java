package algo;

import java.util.Scanner;
import java.util.Stack;

// 1. 문제 자체는 어처피 완전탐색을 목표로 하는 문제
// 공부하는 의미로 푸는 것이기 때문에, bfs & dfs로 전부 코딩해보기

public class boj_11403 {
    static int[][] map;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int[][] ad = new int[size][size];
        int[] c;
        map = new int[size][size];


        for(int i = 0; i < size; ++i) {
            for(int j = 0; j < size; ++j) {
                ad[i][j] = sc.nextInt();
                map[i][j] = ad[i][j];
            }
        }

        for(int i = 0; i < size; ++i) {
            c = new int[size];
            dfs(ad, c, i);

        }

        for(int i = 0; i < size; ++i) {
            for(int j = 0; j < size; ++j) {
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }
    }


    static void dfs(int[][] ad, int[] c, int start) {

        // dfs는 깊이 우선 탐색, 깊이를 우선으로 탐색하기 때문에 스택을 이용한다.
        // 방문 배열의 경우 0인 경우 미방문, 1인 경우 방문

        Stack<Integer> s = new Stack<>();
        s.push(start);

        int n = ad.length;

        while(!s.isEmpty()) {

            int v = s.peek(); // 스택 최상단 원소를 꺼내온다.

            boolean flag = false;

            for(int i = 0; i < n; ++i) {

                if(ad[v][i] == 1 && c[i] == 0) {
                    s.push(i);
                    map[start][i] = 1;
                    c[i] = 1;
                    flag = true;

                    break;
                }

            }
            if(!flag) {
                s.pop();
            }
        }
    }

    static void bfs() {
        // bfs는 너비 우선 탐색, 너비를 우선으로 탐색하려면 모든 노드가 같은 뎁스와 권리(?)를 가져야 하므로 큐를 이용

    }

}