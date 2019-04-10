package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num_4963 {
    public static int[] dx = {0,0,1,-1, 1,1,-1,-1};
    public static int[] dy = {1,-1,0,0, 1,-1,1,-1};
    public static int count = 0;
    static int w;
    static int h;
    static public void dfs(int y, int x, int[][] visit, int[][] map)
    {
        // 방문하면 1
        visit[y][x] = 1;
        for(int k=0; k<8; k++)
        {
            int nx = x+dx[k];
            int ny = y+dy[k];

            if(ny > 0 && ny < h+1 && nx > 0 && nx < w+1)
            {
                if(visit[ny][nx] == 0 && map[ny][nx] == 1)
                {
                    dfs(ny,nx,visit,map);
                }
            }
        }

    }
    static public void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] size;
        boolean flag = true;
        while(true)
        {
            size = in.readLine().split(" ");
            w = Integer.parseInt(size[0]);
            h = Integer.parseInt(size[1]);
            count = 0;
            if(w == 0 && h == 0)
            {
                break;
            }
            int[][] visit = new int[h + 1][w + 1];
            int[][] map = new int[h + 1][w + 1];
            String[] input;

            for (int i = 1; i < h + 1; i++)
            {
                input = in.readLine().split(" ");
                for (int j = 1; j < w + 1; j++)
                {
                    map[i][j] = Integer.parseInt(input[j - 1]);
                    visit[i][j] = 0;
                }
            }

            for(int i=1; i<h+1; i++)
            {
                for(int j=1; j<w+1; j++)
                {
                    if(visit[i][j] == 0 && map[i][j] == 1 )
                    {
                        dfs(i,j,visit,map);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
