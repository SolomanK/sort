package sort;

public class Quick {

    public static int[] sort(int[] arr){
        find(arr, 0, arr.length);
        return arr;
    }

    private static void find(int[] arr, int start, int end) {
        int base = arr[start];
        int empty = start;
        int i = start;
        int j = end;
        while(i < j){
            while(i < j && arr[empty] < arr[j]){
                j--;
            }
            arr[empty] = arr[j];
            empty = j;
            while (i < j && arr[empty] > arr[i]){
                i++;
            }
            arr[empty] = arr[i];
            empty = i;
        }
        arr[empty] = base;
        if (i - start > 1){
            find(arr, start, i);
        }
        if (end - j > 1){
            find(arr, j, end);
        }
    }
}
