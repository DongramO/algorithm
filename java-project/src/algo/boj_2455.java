package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by idongsu on 14/06/2019.
 */
public class boj_2455 {

    static int sum = 0;
    static int max = 0;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int index = 0;
        while(index < 4) {

            st = new StringTokenizer(br.readLine());

            int up = Integer.parseInt(st.nextToken());
            int down = Integer.parseInt(st.nextToken());

            sum += down;
            sum -= up;

            max = Math.max(max, sum);

            index++;
        }

        System.out.println(max);
    }
}
