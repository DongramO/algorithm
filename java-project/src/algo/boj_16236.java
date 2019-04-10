package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16236 {
    static int size;
    static ArrayList<ArrayList<Fish>> location;
    static int[][] ad;
    static int[][] visit;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0, -1};

    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        ad = new int[size][size];
        visit = new int[size][size];

        StringTokenizer st;

        for(int i = 0; i < size; ++i) {
            st = new StringTokenizer(br.readLine());
            int index = 0;

            while(st.hasMoreTokens()) {
                int size = Integer.parseInt(st.nextToken());
                ad[i][index++] = size;
            }
        }

        for(int i = 0; i < size; ++i) {
            for( int j = 0; j < size; ++j) {
                System.out.print(ad[i][j]);
            }
            System.out.println("");
        }

        Fish 상어 = search_fish(ad); // 물고기의 위치를 찾는다.
        bfs(ad, visit, 상어);

        System.out.print("시간" + 상어.time);


    }

    public static int bfs(int[][] ad, int[][] visit, Fish 상어) {

        Queue<Fish> q = new LinkedList<>();

        int n = ad.length;

        q.add(상어);
        System.out.print("상어위치" + 상어.y + " " + 상어.x);

        while(!q.isEmpty()) {

            상어 = q.poll();

            // 상좌우하 로 움직인다
            for(int i = 0; i < 4; ++i) {

                int cur_x = 상어.x + dx[i];
                int cur_y = 상어.y + dy[i];

                if(cur_x < 0 || cur_x > n || cur_y < 0 || cur_y > n) continue; // 배열 범위 벗어난 경우

                if(visit[cur_y][cur_y] == -1) continue;

                if(ad[cur_y][cur_x] > 상어.size) continue;

                visit[cur_y][cur_x] = -1;
                q.add(new Fish(cur_x, cur_y, ad[cur_y][cur_x], 상어.time, 상어.eat));

                // 상어 사이즈보다 작고, 0보다 클 떄(물고기가 있을 떄)
                if(ad[상어.y][상어.x] < 상어.size && ad[상어.y][상어.x] > 0) {

                    ad[상어.y][상어.x] = 0;
                    visit[상어.y][상어.x] = -1;
                    상어.eat++;
                    상어.time++;

                    // 상어가 크기가 커지면 먹은게 리셋되는건지 누적해서 올라가는건지 모르겠음.
                    if(상어.eat == 상어.size) {
                        상어.size++;
                    }
                }
            }

            visit[상어.y][상어.x] = -1;

        }

        return 0;
    }

    public static Fish search_fish(int[][] ad) {
        int x = -1;
        int y = -1;
        Fish fish;

        for(int i = 0; i < ad.length; ++i) {
            for(int j = 0; j < ad.length; ++j) {
                if(ad[i][j] == 9) {
                    y = i;
                    x = j;
                    break;
                }
            }
            if( x != -1 && y != -1) break;
        }
        fish = new Fish(x, y, 2, 0, 0);
        return fish;
    }

    static class Fish {
        int x;
        int y;
        int size;
        int time;
        int eat;

        public Fish(int x, int y, int size, int time, int eat) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.time = time;
            this.eat = eat;
        }
    }
}
