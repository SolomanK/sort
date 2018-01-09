package sort;

import com.sun.org.apache.bcel.internal.generic.SWAP;

public class Insertion {

    public static int[] sort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            for (int j = i; j >= 0; j++){
                if (arr[j-1] > arr[j]){
                    swap(arr, j-1, j);
                } else {
                    break;
                }
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
