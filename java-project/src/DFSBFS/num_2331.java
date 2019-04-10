package DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by idongsu on 2017. 8. 23..
 */
public class num_2331 {
    static public void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> ad =new ArrayList<>();
        int count = 0;
        int t1 = in.nextInt();
        int t2 = in.nextInt();
        boolean flag = true;
        ad.add(t1);
        while(flag)
        {
            String num = String.valueOf(ad.get(count));
            String[] arr = num.split("");
            int element = 0;
            for(int i=0; i<arr.length; i++)
            {
                element += Math.pow(Integer.parseInt(arr[i]),t2);
            }

            if(ad.contains(element))
            {
                count = ad.indexOf(element) -1 ;
                flag = false;
            }
            ad.add(element);
            count++;

        }
        System.out.print(count);
    }
}
