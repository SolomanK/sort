package sort;

public class Selection {

    public static int[] sort(int[] arr){
        for (int i = 0; i < arr.length -1; i++){
            for (int j = i+1; j < arr.length; j++){
                if (arr[i] > arr[j]){
                    swap(arr, i, j);
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
