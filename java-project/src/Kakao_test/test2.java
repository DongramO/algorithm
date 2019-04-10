package Kakao_test;

import java.util.Arrays;

/**
 * Created by idongsu on 2017. 9. 16..
 */
public class test2 {
    public static void main(String args[])
    {
        String[] board = {
                "TTTANT",
                "RRFACC",
                "RRRFCC",
                "TRRRAA",
                "TTMMMF",
                "TMMTTJ"};

        int m = 6;
        int n = 6;

        test2Sol ts = new test2Sol();
        ts.solution(m,n,board);
    }
}
class test2Sol {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        int[][] square = new int[m][n];
        String[][] map = new String[m][n];
        String[][] new_map = new String[m][n];
        int[][] count = new int[m][n];
        int total = 0;

        for (int i = 0; i < m; ++i)
            Arrays.fill(count[i], -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].substring(j, j + 1);
            }
        }
        int flag =1;
        while (flag != 0)
        {
            flag = 0;
            for (int i = 0; i < m - 1; ++i) {
                for (int j = 0; j < n - 1; j++) {

                    String check = map[i][j];

                    if (map[i + 1][j].equals(check) && map[i][j + 1].equals(check) && map[i + 1][j + 1].equals(check) && check != "0")
                    {
                        count[i + 1][j] = 9;
                        count[i][j + 1] = 9;
                        count[i + 1][j + 1] = 9;
                        count[i][j] = 9;
                        flag++;
                    }
                }
            }

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; j++) {
                    if (count[i][j] == 9) {
                        map[i][j] = "0";
                    }
                }
            }


            for (int i = m - 1; i >= 0; --i) {
                for (int j = n - 1; j >= 0; --j) {
                    for (int k = m - 1; k > i; --k) {
                        if (map[k][j].equals("0"))
                        {
                            String temp = map[k][j];
                            map[k][j] = map[i][j];
                            map[i][j] = temp;

                            int tmp = count[k][j];
                            count[k][j] = count[i][j];
                            count[i][j] = tmp;
                        }
                    }

                }
            }


        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (count[i][j] == 9) {
                    total +=1;
                }
            }
        }


        System.out.println(total);
        return answer;
    }
}