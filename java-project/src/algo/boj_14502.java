package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by idongsu on 01/06/2019.
 */
public class boj_14502 {
    static int cnt;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] reset;
    static int row;
    static int column;

    static ArrayList<Dot> virus;
    static int[][] arr;
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        virus = new ArrayList<>();

        row = Integer.parseInt(temp[0]);
        column = Integer.parseInt(temp[1]);

        arr = new int[row][column];
        reset = new int[row][column];

        StringTokenizer st;

        for(int i = 0; i < row; ++i) {
            st = new StringTokenizer(br.readLine());
            int index = 0;

            while(st.hasMoreTokens()) {

                int element = Integer.parseInt(st.nextToken());

                if(element == 2) virus.add(new Dot(i, index));

                arr[i][index++] = element;
            }
        }

        reset();
        int max = 0;

        for(int x1 =0; x1 <row; ++x1) {
            for(int y1=0; y1<column; ++y1) {

                if(reset[x1][y1] != 0 ) continue;

                for(int x2=0; x2<row; ++x2) {
                    for(int y2=0; y2<column; ++y2) {

                        if(x1 == x2 && y1 == y2) continue;
                        if(reset[x2][y2] != 0 ) continue;

                        for(int x3=0; x3<row; ++x3) {
                            for(int y3=0; y3<column; ++y3) {

                                if(x1 == x3 && y1 == y3) continue;
                                if(x2 == x3 && y2 == y3) continue;

                                if(reset[x3][y3] != 0 ) continue;

                                reset[x1][y1] = 1;
                                reset[x2][y2] = 1;
                                reset[x3][y3] = 1;

                                for(int i=0; i < virus.size(); i++)  bfs(virus.get(i));

                                max = Math.max(max, check());
                                reset();
                            }
                        }
                    }
                }
            }
        }
        System.out.print(max);
    }

    static void bfs(Dot start) {
        Queue<Dot> q = new LinkedList<>();

        q.add(start);

        while(!q.isEmpty()) {

            Dot temp = q.poll();

            for(int i=0; i<4; ++i) {

                int newX = temp.x + dx[i];
                int newY = temp.y + dy[i];

                if(newX < 0 || newX >= row || newY >= column || newY < 0) continue;

                if(reset[newX][newY] == 2 || reset[newX][newY] == 1) continue;

                // 다음 노드 추가
                q.add(new Dot(newX, newY));

                // 바이러스가 지나간 곳은 감염
                reset[newX][newY] = 2;
            }
        }
    }
    public static int check() {
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(reset[i][j] == 0) count++;
            }
        }
        return count;
    }

    static void reset() {
        for(int i=0; i<row; ++i) {
            for(int j=0; j<column; ++j) {
                reset[i][j] = arr[i][j];
            }
        }
    }
    static class Dot {

        int x, y;

        Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

