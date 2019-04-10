package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num_2146 {

    static int h;
    static Queue<Element2> que;
    static int[][] map;
    static int[][] group;
    static int[] dx = {0 ,0 ,1, -1};
    static int[] dy = {1 ,-1 ,0, 0};
    static int[][] dis;
    static int ans;

    static public void main(String args[]) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] size;
        size = in.readLine().split(" ");
        h = Integer.parseInt(size[0]);

        int num = 0;

        map = new int[h][h];
        dis = new int[h][h];
        group = new int[h][h];
        que = new <Element2>LinkedList();

        for (int i = 0; i < h; ++i)
        {
            size = in.readLine().split(" ");
            for (int j = 0; j < h; ++j)
            {
                map[i][j] = Integer.parseInt(size[j]);
            }
        }

        for (int i = 0; i < h; ++i)
        {
            for (int j = 0; j < h; ++j)
            {
                System.out.print(group[i][j]);
            }
            System.out.println("");
        }

        for (int i = 0; i < h; ++i)
        {
            for (int j = 0; j < h; ++j)
            {
                if(map[i][j] == 1 && group[i][j] == 0)
                {
                    group[i][j] = ++num;
                    que.offer(new Element2(j, i));
                    bfs(num);

                }
            }
        }
        for (int i = 0; i < h; ++i)
        {
            for (int j = 0; j < h; ++j)
            {
               System.out.print(group[i][j]);
            }
            System.out.println("");
        }
        ans = -1;
        for(int l=1; l<num; ++l)
        {
            for(int i=0; i<h; ++i)
            {
                for(int j=0; j<h; ++j)
                {
                    dis[i][j] = -1;
                    if(group[i][j] == l)
                    {
                        que.add(new Element2(j,i));
                        dis[i][j] = 0;
                    }
                }
            }

            bfs2();

            for(int i=0; i<h; ++i)
            {
                for(int j=0; j<h; ++j)
                {
                    if(map[i][j] == 1 && group[i][j] != l)
                    {
                        if(ans == -1 || dis[i][j]-1 < ans)
                        {
                            ans = dis[i][j]-1;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
    //그룹화 하는 bfs
    static void bfs(int num)
    {
        while(!que.isEmpty())
        {
            Element2 element = que.remove();
            int x = element.x;
            int y = element.y;

            for(int k=0; k<4; k++)
            {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx >=0 && nx< h && ny >= 0 && ny < h)
                {
                    if(map[ny][nx] == 1 && group[ny][nx] == 0)
                    {
                        que.add(new Element2(nx,ny));
                        group[ny][nx] = num;
                    }
                }
            }
        }
    }

    // 가까운 섬을 찾아내는 bfs
    static void bfs2()
    {
        while(!que.isEmpty())
        {
            Element2 element = que.remove();
            int x = element.x;
            int y = element.y;

            for(int k=0; k<4; k++)
            {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx >=0 && nx< h && ny >= 0 && ny < h)
                {
                    if(dis[ny][nx] == -1)
                    {
                        dis[ny][nx] = dis[y][x] + 1;
                        que.add(new Element2(nx,ny));
                    }
                }
            }
        }
    }
}
class Element2{
    int x;
    int y;
    public Element2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

