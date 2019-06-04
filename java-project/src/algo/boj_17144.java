package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 04/06/2019.
 */
public class boj_17144 {

    static int r,c,t;
    static int[][] map, amount;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Dot> list;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        list = new ArrayList<>();

        int temp = 0;
        for(int i=0; i<r; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <c; ++j) {
                temp = Integer.parseInt(st.nextToken());

                if (temp == -1) list.add(new Dot(i, j));
                map[i][j] = temp;

            }
        }

        int time = 0;

        while(time < t) {

            amount = new int[r][c];

            for(int i=0; i<r; ++i) {
                for(int j=0; j<c; ++j) {
                    if(map[i][j] >= 5)  {
                        spread(i, j);
                    }
                }
            }

            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    if(amount[i][j] != 0){
                        map[i][j] += amount[i][j];
                        amount[i][j] = 0;
                    }
                }
            }

            int[][] tempMap = map;

            map = circular(list.get(0).x, list.get(0).y, list.get(1).x, list.get(1).y, tempMap);
            time++;
        }

        int sum = 0;

        for(int i=0; i<r; ++i) {
            for(int j=0; j<c; ++j) {
                if(map[i][j] > 0)  sum += map[i][j];
            }
        }

        System.out.println(sum);

    }
    static int[][] circular(int x, int y, int x2, int y2, int[][] tempMap) {
        // Top purifier
        for (int i=x-2; i>=0; i--) tempMap[i+1][0] = map[i][0];  // ↓
        for (int i=0; i<c-1; i++) tempMap[0][i] = map[0][i+1];    // ←
        for (int i=0; i<x; i++) tempMap[i][c-1] = map[i+1][c-1]; // ↑
        for (int i=c-2; i>=0; i--) tempMap[x][i+1] = map[x][i]; // →

        tempMap[x][1] = 0;
        tempMap[x][y] = -1;

        // Bottom purifier
        for (int i=x2+1; i<r-1; i++) tempMap[i][0] = map[i+1][0];   // ↑
        for (int i=0; i<c-1; i++) tempMap[r-1][i] = map[r-1][i+1];  // ←
        for (int i=r-2; i>=x2; i--) tempMap[i+1][c-1] = map[i][c-1];// ↓
        for (int i=c-2; i>=0; i--) tempMap[x2][i+1] = map[x2][i];   // →

        tempMap[x2][1] = 0;
        tempMap[x2][y2] = -1;

        return tempMap;
    }



    static void spread(int row, int col) {


        int dAmount = map[row][col]/5;

        for(int i=0; i<4; ++i) {

            int newX = row + dx[i];
            int newY = col + dy[i];

            if(newX >= 0 && newX < r && newY >= 0 && newY < c && map[newX][newY] != -1) {
                amount[newX][newY] += dAmount;
                map[row][col] -= dAmount;
            }

        }
    }

    static class Dot {
        int x,y;

        Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

