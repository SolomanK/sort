package sort;

import java.util.Arrays;

public class Bubble {

    public static int[] sort(int[] arr){
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - i - 1; j++){
                if (arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag){
                return arr;
            }
        }
        return arr;
    }




    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
