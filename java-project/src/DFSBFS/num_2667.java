package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num_2667 {
    static int house = 1;

    static public void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        int k = Integer.parseInt(in.readLine());

        //정방형 배열
        int[][] arr = new int[k + 1][k + 1];
        String[] input = new String[k + 1];
        int[][] visit = new int[k + 1][k + 1];
        ArrayList<Integer> house_m = new ArrayList<>();
        int num = 0;
        for (int i = 1; i < k + 1; i++) {
            input = in.readLine().split("");
            for (int j = 1; j < k + 1; j++) {
                arr[i][j] = Integer.parseInt(input[j - 1]);
                visit[i][j] = 0;
            }
        }

        for (int i = 1; i < k + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (arr[i][j] == 1 && visit[i][j] == 0) {
                    house = 0;
                    num++;
                    dfs(i, j, visit, arr, num);
                    house_m.add(house);
                }
            }
        }

        System.out.println(num);
        Ascending ascending = new Ascending();
        Collections.sort(house_m,ascending);
        for (int i = 0; i < house_m.size(); i++) System.out.println(house_m.get(i));
    }

    static public void dfs(int x, int y, int[][] visit, int[][] arr, int num) {
        if (visit[x][y] != 0) return;

        visit[x][y] = num;
        house++;
        if (x - 1 > 0 && arr[x - 1][y] == 1) {
            dfs(x - 1, y, visit, arr, num);

        }

        if (x + 1 < visit.length && arr[x + 1][y] == 1) {
            dfs(x + 1, y, visit, arr, num);

        }

        if (y - 1 > 0 && arr[x][y - 1] == 1) {
            dfs(x, y - 1, visit, arr, num);

        }

        if (y + 1 < visit.length && arr[x][y + 1] == 1) {
            dfs(x, y + 1, visit, arr, num);

        }
    }


}
class Ascending implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}
