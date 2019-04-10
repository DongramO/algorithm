package DFSBFS;

/**
 * Created by idongsu on 2017. 8. 2..
 */
public class BFS_exam
{
    static int n,cnt;
    static int[][] map = new int[10][10];
    static int[] x = new int[100];
    static int[] y = new int[100];
    static int[] l = new int[100];

    static public void main(String args[])
    {

    }

    static void enqueue(int _x,int _y, int _l)
    {
        x[cnt] = _x;
        y[cnt] = _y;
        l[cnt] = _l;
        cnt++;
    }
    static void BFS(int _x, int _y)
    {
        int pos = 0;

        // 시작점의 좌표 정보와 길이를 큐에 삽입한다
        enqueue(_x, _y, 1);
        // 더 이상 방문할 지점이 없거나, 도착 지점에 도착하면 루프를 탈출한다
        while (pos < cnt && (x[pos] != n - 1 || y[pos] != n - 1))
        {
            // 두 번 방문하게 하면 안되므로, 이미 지나갔다는 표시를 해둔다
            map[y[pos]][x[pos]] = 0;

            // 위로 갈 수 있다면, 위 지점의 좌표 정보와 길이를 큐에 삽입한다
            if (y[pos] > 0 && map[y[pos] - 1][x[pos]] == 1)
                enqueue(x[pos], y[pos] - 1, l[pos] + 1);
            // 아래로 갈 수 있다면, 아래 지점의 좌표 정보와 길이를 큐에 삽입한다
            if (y[pos] < n - 1 && map[y[pos] + 1][x[pos]] == 1)
                enqueue(x[pos], y[pos] + 1, l[pos] + 1);
            // 왼쪽으로 갈 수 있다면, 왼쪽 지점의 좌표 정보와 길이를 큐에 삽입한다
            if (x[pos] > 0 && map[y[pos]][x[pos] - 1] == 1)
                enqueue(x[pos] - 1, y[pos], l[pos] + 1);
            // 오른쪽로 갈 수 있다면, 오른쪽 지점의 좌표 정보와 길이를 큐에 삽입한다
            if (x[pos] < n - 1 && map[y[pos]][x[pos] + 1] == 1)
                enqueue(x[pos] + 1, y[pos], l[pos] + 1);

            // 큐의 다음 순서의 지점을 방문한다
            pos++;
        }

        // cnt가 pos보다 크다면, 도착 지점에 무사히 도착한 것이라고 말할 수 있다.
        // 위의 반복문은 도착점에 도착하게 되면 루프를 바로 빠져나오기 때문에,
        // 길이를 삽입하는 큐의 마지막 요소가 최단 경로의 길이라고 할 수 있다.
        if (pos < cnt)
            System.out.printf("최단 경로 길이: %d\n", l[pos]);
    }

}

