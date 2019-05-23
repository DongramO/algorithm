package Data_Structure;


import java.util.Arrays;

public class Ex_selection_sort {
    public static void main(String args[]) {
        int[] arr;
        arr = My_selection.init_array(30);
        System.out.println("정렬 전" + Arrays.toString(arr));

        arr = My_selection.insertion(arr);

        System.out.print("정렬 후" + Arrays.toString(arr));
    }
}

class My_selection {

    static int[] init_array(int size) {
        int[] arr  = new int[size];

        for(int i =0; i < size; ++i) {
            arr[i] = (int)(Math.random() * size) + 1;
        }
        return arr;
    }

    static int[] insertion(int[] arr) {
        int temp;

        for(int i=0; i<arr.length-1; i++) {
            temp = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] <= arr[temp]) temp = j; // 가장 작은 원소의 index => temp;
            }

            arr = swap(i, temp, arr);
        }
        return arr;
    }

    static private int[] swap(int a, int b, int[] arr) {
        int temp = 0;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }
}