package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num_7576 {
    public static void main(String args[]) throws IOException
    {
        Solver s = new Solver();
        s.solve();
    }
}
class Solver
{
    public void solve() throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] insert = in.readLine().split(" ");
        StringTokenizer st;
        //배열 크기를 입력받고
        int m = Integer.parseInt(insert[0]);
        int n = Integer.parseInt(insert[1]);
        int[][] bfs = new int[n+1][m+1];

        //배열 값을 입력
        for(int i=1; i<n+1; ++i)
        {
            st = new StringTokenizer(in.readLine());
            for(int j=1; j<m+1; ++j)
            {
                bfs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 큐 생성
        //익은 토마토의 좌표값을 큐에 넣어주고
        Queue<Node> q = new LinkedList<>();
        for(int i=1; i<n+1; ++i)
        {
            for(int j=1; j<m+1; ++j)
            {
                if(bfs[i][j] == 1) q.add(new Node(i,j)); // 익은 토마토 좌표값 큐에 입력
            }
        }
        //큐를 확인하며 익은 토마토 좌표의 상하좌우를 익게 만들어주고, 큐에 다시 넣어주고
        while(!q.isEmpty())
        {
            Node cur = q.poll();
            for(int dx = -1; dx <= 1; ++dx)
            {
                for(int dy = -1; dy <= 1; ++dy)
                {
                    if(Math.abs(dx) + Math.abs(dy) == 1)
                    {
                        int nx = cur.x + dx;
                        int ny = cur.y + dy;
                        if(1 <= nx && nx < n+1 && 1 <= ny && ny < m+1 && bfs[nx][ny] == 0){
                            bfs[nx][ny] = bfs[cur.x][cur.y] + 1;
                            q.add(new Node(nx, ny));
                        }
                    }
                }
            }
        }
        for(int i=1; i<n+1; ++i)
            System.out.println(Arrays.toString(bfs[i]));

        int ans =1;
        for(int i=1; i<n+1; ++i)
        {
            for(int j=1; j<m+1; ++j)
            {
                if(bfs[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                ans = Math.max(ans, bfs[i][j]);
            }
        }
        System.out.println(ans-1);
        //걸린 일수를 확인
    }
    class Node
    {
        int x,y;
        public Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}