package Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class num_1920
{
    static int[] arr;
    static public void main(String args[]) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int k = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());
        arr = new int[k];
        for(int i=0; i<k;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int l = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());
        boolean exist = false;

        for(int i=0; i<l; ++i)
        {
            int m = Integer.parseInt(st.nextToken());
//            Search(m);
            System.out.println(Search(m));
        }
    }

    static int Search(int m)
    {
        int low=0;
        int high = arr.length-1;
        int mid;

        while(low <= high)
        {
            mid  = (low+high) / 2;
            if (m > arr[mid])
                low = mid+1;
            else if(m < arr[mid])
                high = mid-1;
            else if(m == arr[mid])
                return 1;

        }
        return 0;
    }
}
