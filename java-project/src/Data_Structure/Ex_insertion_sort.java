package Data_Structure;

import java.util.Arrays;

/**
 * Created by idongsu on 22/05/2019.
 */
public class Ex_insertion_sort {
    static int[] arr;
    public static void main(String arg[]) {
        init_array(20);
        System.out.println("정렬 전 " + Arrays.toString(arr));
        insertion();
        System.out.println("정렬 후 " + Arrays.toString(arr));
    }

    static void init_array(int size) {
        arr = new int[size];

        for(int i =0; i < size; ++i) {
            arr[i] = (int)(Math.random() * size) + 1;
        }
    }

    static void insertion() {
        for(int i=1; i < arr.length; i++) {
            int key = arr[i];
            int j = i-1;

           while(j >=0 && arr[j] >= key) {
             arr[j+1] = arr[j];
             j--;
           }

           arr[j+1] = key;
       }
    }
}
