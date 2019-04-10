package DFSBFS;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by idongsu on 2017. 8. 18..
 */
public class dfs_list_exam
{
    static int Nv;
    static int Ne;
    static ArrayList<ArrayList<Integer>> ad;
    static boolean[] visit;

    public static void dfs(int i){
        visit[i] = true;
        System.out.print(i);

        for(int j : ad.get(i)){  // 배열 null check
            if(visit[j] == false){
                dfs(j);
            }
        }
    }

    static public void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        Nv = in.nextInt();
        Ne = in.nextInt();

        ad = new ArrayList(Nv+1);
        visit = new boolean[Nv+1];

        for(int i=0; i<Nv+1; i++)
        {
            ad.add(new ArrayList());
        }

        for(int i=0; i < Ne; i++)
        {
            int t1 = in.nextInt();
            int t2 = in.nextInt();

            ad.get(t1).add(t2);
            ad.get(t2).add(t1);
        }

        dfs(1);
    }

}
