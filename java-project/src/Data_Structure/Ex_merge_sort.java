package Data_Structure;

import java.util.Arrays;

public class Ex_merge_sort {
    static int[] arr;
    public static void main(String arg[]) {

        init_array(6);
        System.out.println("정렬 전 " + Arrays.toString(arr));

        mergeSort(0, arr.length-1);
        System.out.println("정렬 후 " + Arrays.toString(arr));

    }

    static void init_array(int size) {
        arr = new int[size+1];

        for(int i =0; i < size; ++i) {
            arr[i] = (int)(Math.random()*size) + 1;
        }
    }

    static void mergeSort(int start, int end) {
        if(start < end) {

            int middle = (start + end)/ 2;

            mergeSort(start, middle); // 앞에꺼
            mergeSort(middle+1, end); // 뒤에꺼

            conquer(start, end, middle);
        }
    }

    static void conquer(int start, int end, int middle) {
        int[] temp_arr = new int[end-start+1];
        int i = start;
        int j = middle +1;
        int k = 0;

        while(i <= middle && j <= end) {
            // 두개를 비교해서 큰 값을 넣는다
            if(arr[i] < arr[j]) temp_arr[k++] = arr[i++];
            else temp_arr[k++] = arr[j++];
        }

        // 나머지 값을 다 넣는다.
        // 두개의 인덱스 start, middle 중에서
        // 각 분할된 범위에서 start <= middle 이고 middle <= end 까지의 범위를 갖는다
        while(i <= middle) temp_arr[k++] = arr[i++];
        while(j <= end) temp_arr[k++] = arr[j++];

        for(int m=0; m<temp_arr.length; m++) {
            arr[start++] = temp_arr[m];
        }
    }
}
