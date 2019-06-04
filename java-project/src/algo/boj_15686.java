package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 04/06/2019.
 */
public class boj_15686 {
    static int[][] arr;
    static int[][] arr2;
    static int n, m, result = Integer.MAX_VALUE;
    static int cnt;
    static boolean[] visit;
    static int[] output;
    static ArrayList<Node> house;
    static ArrayList<Node> shop;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] k = br.readLine().split(" ");
        n = Integer.parseInt(k[0]);
        m = Integer.parseInt(k[1]);

        arr = new int[n][n];
        arr2 = new int[n][n];



        StringTokenizer st;

        house = new ArrayList<>();
        shop = new ArrayList<>();


        // array initialize
        for(int i = 0; i < arr.length; ++i) {

            st = new StringTokenizer(br.readLine());

            for(int j=0; j<arr.length; ++j) {

                int d = Integer.parseInt(st.nextToken());

                if(d == 1) {
                    house.add(new Node(i,j));
                } else if (d == 2) {
                    shop.add(new Node(i,j));
                }

                arr[i][j] = d;

            }
        }

        visit = new boolean[shop.size()];
        output = new int[shop.size()]; // 너는 정체가 뭐냐


        solve();
        System.out.println(result);
    }


    static void solve() {

        for (int i = 0; i < shop.size(); ++i) {
            visit[i] = true;
            recursive(i, 0);
            visit[i] = false; // 아직 잘 모르겠음
        }

    }

    static int distance(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    static void recursive(int start, int depth) {
        // 치킨집을 선택할 때, 부분집합의 index를 골라주기 위해
        output[depth] = start+1; // 1개 선택 했을 때 최소값을 구하는건가?

        for(int i = start; i < shop.size(); ++i) {
            if(visit[i]) continue;

            visit[i] = true;
            recursive(i, depth+1);
            visit[i] = false;
        }


        // 탈출 조건
        if(depth == m-1) {

            int sum = 0;
            int current = 0;

            for(int j=0; j< house.size(); ++j) {

                int min = Integer.MAX_VALUE;

                for(int i=0; i< m; ++i) {

                    current = distance(house.get(j), shop.get(output[i] - 1));

                    min = Math.min(min, current);

                }
                sum += min;
            }

            result = Math.min(result, sum);
        }
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
