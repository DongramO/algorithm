import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NHN4 {
    static Queue<Element2> que;
    static int[] dx = {0 ,0 ,1, -1};
    static int[] dy = {1 ,-1 ,0, 0};
    static int[][] map;
    static int[][] set;
    static int m;
    static ArrayList<Integer> count;
    static public void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        m = Integer.parseInt(in.readLine());
        map = new int[m+1][m+1];
        set = new int[m][m];

        count = new ArrayList<>();
        for(int i=0; i<m; ++i)
        {
            st = new StringTokenizer(in.readLine());
            for(int j=0; j<m; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        que = new <Element2>LinkedList();

        for(int i=0; i<m; ++i)
        {
            for(int j=0; j<m; ++j)
            {
                if(map[i][j] == 1 )
                {
                    que.add(new Element2(i,j));
                    bfs(0,0);
                }
            }
        }
        Collections.sort(count);
        System.out.println(count.size());
        if(count.size() != 0)
        {
            for(int i=0; i<count.size(); ++i)
                if(i != count.size()-1)
                System.out.print(count.get(i)+" ");
            else
                {
                    System.out.print(count.get(i));
                }
            System.out.println("");
        }

    }
    static void bfs(int width, int height)
    {
        int amount = 1;
        while(!que.isEmpty())
        {
            Element2 element = que.remove();
            int x = element.x;
            int y = element.y;

            for(int k=0; k<4; k++)
            {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx >=0 && nx< m && ny >= 0 && ny < m)
                {
                    if(map[nx][ny] == 1)
                    {
                        que.add(new Element2(nx,ny));
                        map[nx][ny] = -1;
                        set[nx][ny] = amount;
                        amount++;
                    }
                }
            }

        }
        count.add(amount-1);

    }
}

class Element2 {
    int x;
    int y;

    public Element2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
