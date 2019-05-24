package Data_Structure;

import java.util.Arrays;

/**
 * Created by idongsu on 23/05/2019.
 */
public class Ex_quick_sort {
    static int[] arr;
    public static void main(String arg[]) {

        init_array(10);
//        System.out.println("정렬렬 전 " + Arrays.toString(arr));
        arr = new int[]{2, 8, 3, 10, 6, 5, 7, 1, 9, 4};
        System.out.println("원본" + Arrays.toString(arr));
        quickSort(0, arr.length-1);
        System.out.println("정렬 후 " + Arrays.toString(arr));
    }

    static void init_array(int size) {
        arr = new int[size];

        for(int i =0; i < size; ++i) {
            arr[i] = (int)(Math.random()*size) + 1;
        }
    }

    static void quickSort(int left, int right) {
        int i, j, pivot, tmp;
        System.out.println("LEFT :  "+ left + " RIGHT " + right + " PIVOT :" +  (left+right)/2);
        System.out.println("원본" + Arrays.toString(arr));
        System.out.println();

        if (left < right) {
            i = left;   j = right;
            pivot = arr[(left+right)/2];

            //분할 과정
            while (i < j) {
                while (arr[j] > pivot) j = j-1;
                // 이 부분에서 arr[j-1]에 접근해서 익셉션 발생가능함.
                while (i < j && arr[i] <= pivot) i = i+1;

                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

            }
            System.out.println("i :  "+ i + " j : " + j + " PIVOT :" +  (left+right)/2);
            System.out.println("끝" + Arrays.toString(arr));

            tmp = pivot;
            arr[(left+right)/2] = arr[j];
            arr[j] = tmp;

            System.out.println("끝" + Arrays.toString(arr));


//            //정렬 과정
//            quickSort(left, i - 1);
//            quickSort(i + 1, right);
        }
    }

//    static void quickSort(int left, int right) {
//
//        if(left < right) {
//
//            int pivot = partition(left, right);
//
//            quickSort(left, pivot-1);
//            quickSort(pivot+1, right);
//        }
//    }
//
//    static int partition(int left, int right) {
//
//        int pivot = (left + right)/2;
//        int start = left;
//        int end = right;
//
//        while (left < right) {
//
//            while (arr[left] < arr[pivot] && left < end) left++;
//            while (arr[right] > arr[pivot]) right--;
//
//            System.out.println("LEFT : " + left + " RIGHT :"+ right);
//            if (left <= right) {
//
//                int temp = arr[left];
//                arr[left] = arr[right];
//                arr[right] = temp;
//
//            }
//        }
//        int temp = arr[left];
//        arr[left] = arr[right];
//        arr[right] = temp;
//
//        System.out.println("PIVOT : " + pivot);
//        System.out.println("정렬 후 " + Arrays.toString(arr));
//        return pivot;
//    }
}
