package Data_Structure;

import java.util.Arrays;

/**
 * Created by idongsu on 23/05/2019.
 */
public class Ex_quick_sort {
    static int[] arr;
    public static void main(String arg[]) {

        init_array(20);

//        arr = new int[]{2, 4, 1, 4, 4, 4, 7, 1, 5, 4};
        System.out.println("원본" + Arrays.toString(arr));


        quickSort(0, arr.length-1);

        System.out.println("최종" + Arrays.toString(arr));
    }

    static void init_array(int size) {
        arr = new int[size];

        for(int i =0; i < size; ++i) {
            arr[i] = (int)(Math.random()*size) + 1;
        }
    }

    static void quickSort(int left, int right) {
        int i, j, pivot, tmp;

        pivot = (left+right)/2;

        if (left < right) {

            swap(left, pivot);

            //분할 과정
            int border = left + 1 ;
            for(int t= border; t <= right; t++) {
                if(arr[t] < arr[left]) {
                    swap(t, border++);
                }
            }
            swap(left, border-1);

            //정렬 과정
            quickSort(left, border-2);
            quickSort(border, right);
        }
    }

    static void swap(int index , int index2) {
        int temp = arr[index];
        arr[index] = arr[index2];
        arr[index2] = temp;
    }
}
