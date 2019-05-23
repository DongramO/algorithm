package Data_Structure;

import java.util.Arrays;

public class Ex_bubble_sort {
    static int[] arr;
    public static void main(String arg[]) {
        init_array(20);
        System.out.println("정렬 전 " + Arrays.toString(arr));
        bubble();
        System.out.println("정렬 후 " + Arrays.toString(arr));
    }

    static void init_array(int size) {
        arr = new int[size];

        for(int i =0; i < size; ++i) {
            arr[i] = (int)(Math.random()*size) + 1;
        }
    }

    static void bubble() {
        for(int i=0; i< arr.length; ++i) {
            for(int j=1; j<arr.length-i; ++j) {
                if(arr[j-1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
