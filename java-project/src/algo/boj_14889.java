package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_14889 {

    static int size;
    static int[][] arr;

    static int min = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        arr = new int[size][size];

        StringTokenizer st;

        for(int i=0; i<size; ++i) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<size; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visit = new boolean[size];
        visit[0] = true;


        makeTeam(0, 1, visit);

        System.out.println(min);
    }

    // 크게 봤을 때, index 1번이 포함된 팀과 포함되지 않은 팀
    public static void makeTeam(int index, int count, boolean[] visit) {

        if(count == size / 2) {

            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();

            for(int i=0; i<visit.length; ++i) {
                if(visit[i]) a.add(i);
                else b.add(i);
            }

            int sumA = getStat(a);
            int sumB = getStat(b);
            int k = Math.abs(sumA - sumB);

            min = Math.min(min, k);

            return;

        } else {

            if(index == size-1) {
                return;
            }


            // 다음 원소를 팀원으로 선택 하는지 안하는지에 대한 문제
            makeTeam(index +1, count, visit);

            // 선택했을 때
            visit[index+1] = true;
            makeTeam(index +1, count+1, visit);
            // 백 트레킹 요소
            visit[index+1] = false;
        }
    }

    static public int getStat(ArrayList<Integer> team) {

        int result = 0;

        for(int i=0; i<team.size(); ++i) {

            for(int j=i; j<team.size(); ++j) {

                result += arr[team.get(i)][team.get(j)];
                result += arr[team.get(j)][team.get(i)];
            }
        }

        return result;
    }
}
