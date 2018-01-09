package sort;

public class Merge {

    public static int[] sort(int[] arr){
        mSort(arr, 0, arr.length-1);
        return arr;
    }

    private static void mSort(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (left >= right){
            return;
        }
        mSort(arr, left, mid);
        mSort(arr, mid +1, right);
        merger(arr, left, mid, right);
    }

    private static void merger(int[] arr, int left, int mid, int right) {
        int record = left;
        int record2 = left;
        int m = mid +1;
        int[] temp = new int[arr.length];
        while (left >= mid || m >= right){
            if (arr[left] < arr[m]){
                temp[record++] = arr[left++];
            } else {
                temp[record++] = arr[m++];
            }
        }
        while (left < mid){
            temp[record++] = arr[left++];
        }
        while (m < right){
            temp[record++] = arr[m++];
        }

        while (record2 <= right){
            arr[record2] = temp[record2];
            record2++;
        }
    }


}
