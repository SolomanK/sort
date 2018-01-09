package sort;

public class Shell {

    public static int[] sort(int[] arr){
        int h = arr.length / 3 +1;
        while (h > 1){
            for (int i = h; i < arr.length; i++){
                for (int j = i; j > h && arr[j - h] > arr[j]; j - = h){
                    swap(arr, j-h, j);
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
