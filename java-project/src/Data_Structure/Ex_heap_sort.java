package Data_Structure;

import java.util.Arrays;

/**
 * Created by idongsu on 24/05/2019.
 */
public class Ex_heap_sort {
    static int[] arr;
    public static void main(String arg[]) {

        init_array(20);
        System.out.println("정렬 전 " + Arrays.toString(arr));

        heap();
        System.out.println("1차 heap " + Arrays.toString(arr));
    }

    static void init_array(int size) {
        arr = new int[size];

        for(int i =0; i < size; ++i) {
            arr[i] = (int)(Math.random()*size) + 1;
        }
    }

    static void heapify(int i, int n) {

        int p = i;
        int left_node = i * 2 + 1;
        int right_node = i * 2 + 2;

        if(left_node < n && arr[left_node] > arr[p]) p = left_node;

        if(right_node < n && arr[right_node] > arr[p]) p = right_node;

        if(p != i) {
            swap(p, i);
            heapify(p, n);
        }

    }

    static void heap() {
        int n = arr.length;

        for(int i= n/2 -1; i >= 0; i--) {
            heapify(i, n);
        }

        for(int i = n -1; i >=0; i--) {
            swap(0, i); // 첫 요소와 마지막 요소를 스왑
            heapify(0, i); //
        }
    }

    static void swap(int a, int b) {
        int tmp  = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}