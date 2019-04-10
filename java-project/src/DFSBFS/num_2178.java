package DFSBFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num_2178 {
    static int w,h;
    static Queue<Element> que;
    static int[][] map;
    static int cnt = 0;
    static int[] dx = {0 ,0 ,1, -1};
    static int[] dy = {1 ,-1 ,0, 0};
    static int[][] dis;
    static public void main(String args[]) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] size;
        size = in.readLine().split(" ");
        h = Integer.parseInt(size[0]);
        w = Integer.parseInt(size[1]);

        map = new int[h][w];
        dis = new int[h][w];
        String[] input;

        for (int i = 0; i < h; i++)
        {
            input = in.readLine().split("");
            for (int j = 0; j < w; j++)
            {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        que = new <Element>LinkedList();
        dis[0][0] = 1;
        que.add(new Element(0,0));
        bfs(0,0);

    }

    static void bfs(int width, int height)
    {

        while(!que.isEmpty())
        {
            Element element = que.remove();
            int x = element.x;
            int y = element.y;

            for(int k=0; k<4; k++)
            {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx >=0 && nx< w && ny >= 0 && ny < h)
                {
                    if(map[ny][nx] == 1)
                    {
                        que.add(new Element(nx,ny));
                        map[ny][nx] = -1;
                        dis[ny][nx] = dis[y][x]+1;
                    }
                }
            }
        }
        System.out.println(dis[h-1][w-1]);

        for (int i = 0; i < h; i++)
        {
            for (int j = 0; j < w; j++)
            {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }

    }


}
class Element{
    int x;
    int y;
    public Element(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
