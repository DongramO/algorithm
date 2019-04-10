package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by idongsu on 2017. 8. 25..
 */
public class num_7576_self {

    static int[][] visit;
    static int[][] map;
    static int w,h;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int aws = 0;
    static Queue<Tomato> que = new <Tomato>LinkedList();
    static public void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] size;
        int flag=0;
        size = in.readLine().split(" ");
        h = Integer.parseInt(size[1]);
        w = Integer.parseInt(size[0]);

        map = new int[h][w];
        visit = new int[h][w];

        for(int i=0; i<h; ++i) {
            size = in.readLine().split(" ");
            for(int j=0; j<w; ++j) {
                map[i][j] = Integer.parseInt(size[j]);
                visit[i][j] = -1;
                if(map[i][j] == 1)
                {
                    que.add(new Tomato(j,i,0));
                    visit[i][j] = 0;
                }
            }
        }


        while(!que.isEmpty())
        {
            Tomato tomato = que.remove();
            int x = tomato.x;
            int y = tomato.y;
            int day = tomato.count;

            for(int k=0; k<4; k++)
            {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx >=0 && nx< w && ny >= 0 && ny < h)
                {
                    if(map[ny][nx] == 0 && visit[ny][nx] == -1)
                    {
                        map[ny][nx] = 1;
                        que.offer(new Tomato(nx,ny,day+1));
                        visit[ny][nx] = day+1;
                        aws = day+1;
                    }
                }
            }
        }


        for(int i=0; i<h; ++i) {
            for(int j=0; j<w; ++j) {
                if(visit[i][j] == -1 && map[i][j] == 0)
                {
                    aws = -1;
                    break;
                }
            }
        }
        System.out.print(aws);
    }
}

class Tomato {

    int x,y,count;

    public Tomato(int x, int y, int count)
    {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

