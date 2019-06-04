package algo;

/*
 N,M 크기의 직사각형, 각 칸은 1*1
 각 위치는 (r,c)
 r : 북쪽으로 부터 떨어진 칸의 개수
 c : 서쪽으로 부터 떨어진 칸의 개수

 로봇 청소기는 현재 위치를 청소
 1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향(서쪽?)부터 탐색
 2. 청소 공간이 없다면 왼쪽 방향으로 회전하고 다시 시작
 3. 네 방향이 모두 청소가 되있거나 벽인 경우 바라보는 방향을 유지한채로 한칸 후진하고 2번 실행
 4. 네 방향이 모두 청소가 되었거나 벽인경우 뒤쪽 방향이 벽이라 후진 불가능한 경우 작동을 멈춘다.

 입력 세로 N, 가로 M  (3<= N,M <=50)
 (r,c) - 청소기 시작좌표, 방향 d  북동남서 = {0,1,2,3}
 빈칸은 0, 벽은 1
 장소의 모든 외곽은 벽이다.

 출력 : 로봇 청소기가 청소하는 칸의 개수를 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14503 {
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int n, m, cnt = 1;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] k = br.readLine().split(" ");

        n = Integer.parseInt(k[0]);
        m = Integer.parseInt(k[1]);
        arr = new int[n][m];

        k = br.readLine().split(" ");

        int x = Integer.parseInt(k[0]);
        int y = Integer.parseInt(k[1]);
        int d = Integer.parseInt(k[2]);


        StringTokenizer st;

        for(int i=0; i<n; i++) {

            st = new StringTokenizer(br.readLine());
            int index = 0;

            while(st.hasMoreTokens()) {
                arr[i][index++] =  Integer.parseInt(st.nextToken());;
            }
        }

        dfs(x, y, d);


        for(int i = 0; i<n; i++) System.out.println(Arrays.toString(arr[i]));
        System.out.println(cnt);
    }

    static void dfs(int x, int y, int d) {

        arr[x][y] = 2; // 청소
        int posX, posY;

        for(int i =0; i<4; i++) {

            d = (d + 3) % 4;
            posX = x + dx[d];
            posY = y + dy[d];

            if(posX >= 0 && posX < n && posY >= 0 && posY < m && arr[posX][posY] == 0) {

                cnt++;
                dfs(posX, posY, d);
                return;
            }
        }

        // 현재 방향을 기준으로 뒷 방향
        int back = (d + 2) % 4;

        posX = x + dx[back];
        posY = y + dy[back];

        // 뒷방향으로 이동이 불가능한 경우
        if(posX >= 0 && posX < n && posY >= 0 && posY < m && arr[posX][posY] != 1) {
            dfs(x + dx[back], y + dy[back], d);
        }
    }
}