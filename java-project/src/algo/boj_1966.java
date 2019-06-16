package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by idongsu on 15/06/2019.
 */
public class boj_1966 {

    static int t;
    static Queue<Element> q;
    static ArrayList<Integer> list;
    static int n;
    static int index;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());


        int flag = 0;

        while(flag < t) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            index = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            list = new ArrayList<Integer>();
            q = new LinkedList<>();

            int f = 0;

            while(st.hasMoreTokens()) {

                int k = Integer.parseInt(st.nextToken());

                list.add(k);

                if(index == f) {
                    q.add(new Element(k, true));
                } else {
                    q.add(new Element(k, false));
                }

                f++;
            }

            Collections.sort(list, Collections.reverseOrder());
            System.out.println(search());
            flag++;
        }
    }

    static int search() {

        int b = 0;
        int cnt = 0;

        while(!q.isEmpty()) {

            Element a = q.poll();
            int seq = list.get(b);

            if(a.v == seq) {
                if(a.select) {
                    return ++cnt;
                }
                cnt++;
                b++;
            }
            q.add(a);
        }

        return cnt;
    }

    static class Element {
        int v;
        boolean select;

        Element(int v, boolean select) {
            this.v = v;
            this.select = select;
        }
    }
}
